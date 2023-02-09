package com.a505.hobbyit.oauth;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/oauth")
public class OAuthController {
    private final OAuthService oAuthService;

    /**
     * 카카오 callback
     * [GET] /oauth/kakao/callback
     */
    @ResponseBody
    @GetMapping(value = "/kakao")
    public void kakaoCallback(@RequestParam String code) {
        System.out.println("=========================");
        System.out.println(code);
        System.out.println("=========================");

        String access_Token = oAuthService.getKakaoAccessToken(code);
        System.out.println(access_Token);
        System.out.println("=========================");

        oAuthService.createKakaoUser(access_Token);
        System.out.println("=========================");
    }

}