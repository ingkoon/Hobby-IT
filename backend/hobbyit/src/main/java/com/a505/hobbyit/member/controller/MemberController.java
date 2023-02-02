package com.a505.hobbyit.member.controller;

import com.a505.hobbyit.member.dto.request.*;
import com.a505.hobbyit.member.dto.Response;
import com.a505.hobbyit.jwt.JwtTokenProvider;
import com.a505.hobbyit.common.Helper;
import com.a505.hobbyit.member.dto.response.MemberResponse;
import com.a505.hobbyit.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/member")
public class MemberController {
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberService memberService;
    private final Response response;

    @PostMapping(value = "/signup")
        public ResponseEntity<Void> signUp(@Validated MemberSignupRequest request, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        memberService.signUp(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/login")
    public ResponseEntity<MemberResponse> login(@Validated MemberLoginRequest request, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        MemberResponse response = memberService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/reissue")
    public ResponseEntity<MemberResponse> reissue(@RequestBody MemberReissueRequest request) {
        // validation check
        try {
            MemberResponse memberResponse = memberService.reissue(request);
            return ResponseEntity.ok(memberResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@Validated MemberLogoutRequest request, Errors errors) {
        System.out.println(request.getAccessToken());
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        memberService.logout(request);
        return ResponseEntity.ok().build();
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
