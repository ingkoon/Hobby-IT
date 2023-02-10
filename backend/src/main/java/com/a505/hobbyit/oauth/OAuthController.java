package com.a505.hobbyit.oauth;

import com.a505.hobbyit.member.dto.request.MemberLoginRequest;
import com.a505.hobbyit.member.dto.request.MemberSignupRequest;
import com.a505.hobbyit.member.dto.response.MemberResponse;
import com.a505.hobbyit.member.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/oauth")
public class OAuthController {

    private final OAuthService oAuthService;

    private final MemberService memberService;

    @GetMapping("/kakao/login")
    public void redirectKakao(HttpServletResponse response) throws IOException {
        response.sendRedirect(oAuthService.redirectKakao());
    }

    @ResponseBody
    @GetMapping(value = "/kakao")
    public ResponseEntity<MemberResponse> kakaoCallback(@RequestParam String code) {
        // 1. kakao 에서 받은 access_token을 다시 카카오만의 REDIRECT_URI 로 보내서 사용자 정보를 받음
        String token = oAuthService.getKakaoToken(code);
        List<String> account = oAuthService.getKakaoMember(token);

        // 2. 사용자 정보를 통해 회원가입을 진행
        MemberSignupRequest signupRequest =
                new MemberSignupRequest(account.get(0), account.get(1), account.get(1), account.get(0));
        memberService.signUp(signupRequest);
        memberService.updateSnsMember(account.get(0), account.get(2));

        // 3. 회원가입한 정보로 로그인을 진행
        MemberLoginRequest loginRequest = new MemberLoginRequest(account.get(0), account.get(0));
        MemberResponse response = memberService.login(loginRequest);

        return ResponseEntity.ok(response);
    }

}