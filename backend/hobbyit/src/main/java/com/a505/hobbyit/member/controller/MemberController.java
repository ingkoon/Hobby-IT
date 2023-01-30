package com.a505.hobbyit.member.controller;

import com.a505.hobbyit.member.dto.request.*;
import com.a505.hobbyit.member.dto.Response;
import com.a505.hobbyit.jwt.JwtTokenProvider;
import com.a505.hobbyit.common.Helper;
import com.a505.hobbyit.member.dto.response.MemberTokenResponse;
import com.a505.hobbyit.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/member")
public class MemberController {

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberService memberService;
    private final Response response;

    @PostMapping(value = "/signup")
    public ResponseEntity<MemberTokenResponse> signUp(@RequestBody MemberSignupRequest request) {
        try {
            memberService.signUp(request);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<MemberTokenResponse> login(@RequestBody MemberLoginRequest request) {
        try {
            memberService.login(request);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/reissue")
    public ResponseEntity<?> reissue(@Validated MemberReissueRequest reissue, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return memberService.reissue(reissue);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@Validated MemberLogoutRequest logout, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return memberService.logout(logout);
    }

    @GetMapping("/authority")
    public ResponseEntity<?> authority() {
        log.info("ADD ROLE_ADMIN");
        return memberService.authority();
    }

    @GetMapping("/userTest")
    public ResponseEntity<?> userTest() {
        log.info("ROLE_USER TEST");
        return response.success();
    }

    @GetMapping("/adminTest")
    public ResponseEntity<?> adminTest() {
        log.info("ROLE_ADMIN TEST");
        return response.success();
    }
}
