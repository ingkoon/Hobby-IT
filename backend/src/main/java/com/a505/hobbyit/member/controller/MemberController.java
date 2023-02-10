package com.a505.hobbyit.member.controller;

import com.a505.hobbyit.member.dto.request.*;
import com.a505.hobbyit.member.dto.response.MemberHobbyResponse;
import com.a505.hobbyit.member.dto.response.MemberPendingResponse;
import com.a505.hobbyit.member.dto.response.MemberResponse;
import com.a505.hobbyit.member.dto.response.MypageResponse;
import com.a505.hobbyit.member.service.MemberService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        MemberResponse memberResponse = memberService.reissue(request);
        return ResponseEntity.ok(memberResponse);
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") final String token) {
        memberService.logout(token);
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

    @GetMapping(value = "/{member-nickname}")
    public ResponseEntity<MypageResponse> findMypage(
            @RequestHeader("Authorization") final String token,
            @PathVariable(value = "member-nickname") final String nickname) {
        MypageResponse response = memberService.findMypage(token, nickname);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Void> updateMember(
            @RequestHeader("Authorization") final String token,
            @RequestBody MemberMypageRequest request) {
        memberService.update(token, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/delete")
    public ResponseEntity<Void> deleteMember(@RequestHeader("Authorization") final String token) {
        memberService.delete(token);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/hobby/{member-nickname}")
    public ResponseEntity<List<MemberHobbyResponse>> findMemberHobbies(
            @RequestHeader("Authorization") final String token,
            @PathVariable(value = "member-nickname") final String nickname) {
        List<MemberHobbyResponse> hobbyList = memberService.getHobbyList(token, nickname);
        return ResponseEntity.status(HttpStatus.OK).body(hobbyList);
    }

    @GetMapping(value = "/hobby/pending")
    public ResponseEntity<List<MemberPendingResponse>> findMemberPendings(
            @RequestHeader("Authorization") final String token) {
        List<MemberPendingResponse> pendingList = memberService.getPendingList(token);
        return ResponseEntity.status(HttpStatus.OK).body(pendingList);
    }

}
