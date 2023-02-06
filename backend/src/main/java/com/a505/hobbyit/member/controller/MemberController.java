package com.a505.hobbyit.member.controller;

import com.a505.hobbyit.member.dto.request.*;
import com.a505.hobbyit.jwt.JwtTokenProvider;
import com.a505.hobbyit.member.dto.response.MemberResponse;
import com.a505.hobbyit.member.service.MemberService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/member")
public class MemberController {
    private final MemberService memberService;

    @Value("${spring.mail.username}")
    private String from;

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

    @PostMapping(value = "/reissue")
    public ResponseEntity<MemberResponse> reissue(@RequestBody MemberReissueRequest request) {
        try {
            MemberResponse memberResponse = memberService.reissue(request);
            return ResponseEntity.ok(memberResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<Void> logout(@Validated MemberLogoutRequest request, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        memberService.logout(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/password/reset")
    public ResponseEntity<Void> resetPassword(@Validated MemberMailRequest request, Errors errors) throws MessagingException {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        memberService.resetPassword(request, from);
        return ResponseEntity.ok().build();
    }
}
