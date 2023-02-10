package com.a505.hobbyit.oauth;

import com.a505.hobbyit.member.dto.request.MemberSignupRequest;
import com.a505.hobbyit.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/oauth")
public class OAuthController {
    private final OAuthService oAuthService;
    private final MemberService memberService;

    @ResponseBody
    @GetMapping(value = "/kakao")
    public void kakaoCallback(@RequestParam String code) {
        String token = oAuthService.getKakaoToken(code);
        List<String> account = oAuthService.getKakaoMember(token);
        MemberSignupRequest request =
                new MemberSignupRequest(account.get(0), account.get(1), account.get(1), account.get(0));
        memberService.signUp(request);
        memberService.updateSnsMember(account.get(0), account.get(2));
    }

}