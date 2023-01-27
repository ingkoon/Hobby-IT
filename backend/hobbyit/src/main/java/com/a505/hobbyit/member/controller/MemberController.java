package com.a505.hobbyit.member.controller;

import com.a505.hobbyit.member.dto.*;
import com.a505.hobbyit.member.jwt.JwtTokenProvider;
import com.a505.hobbyit.common.Helper;
import com.a505.hobbyit.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/member")
public class MemberController {

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberService memberService;
    private final MemberResponse response;

    @PostMapping(value = "/signup")
    public ResponseEntity<?> signUp(@Validated MemberSignupRequest signUp, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return memberService.signUp(signUp);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@Validated MemberLoginRequest login, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return memberService.login(login);
    }

    @PostMapping(value = "/reissue")
    public ResponseEntity<?> reissue(@Validated MemberReissueRequest reissue, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return memberService.reissue(reissue);
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<?> logout(@Validated MemberRequest.Logout logout, Errors errors) {
        // validation check
        if (errors.hasErrors()) {
            return response.invalidFields(Helper.refineErrors(errors));
        }
        return memberService.logout(logout);
    }

    @GetMapping(value = "/authority")
    public ResponseEntity<?> authority() {
        log.info("ADD ROLE_ADMIN");
        return memberService.authority();
    }

    @GetMapping(value = "/userTest")
    public ResponseEntity<?> userTest() {
        log.info("ROLE_USER TEST");
        return response.success();
    }

    @GetMapping(value = "/adminTest")
    public ResponseEntity<?> adminTest() {
        log.info("ROLE_ADMIN TEST");
        return response.success();
    }
}
