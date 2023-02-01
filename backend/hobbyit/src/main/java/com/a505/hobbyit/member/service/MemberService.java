package com.a505.hobbyit.member.service;

import com.a505.hobbyit.member.dto.request.MemberLoginRequest;
import com.a505.hobbyit.member.dto.request.MemberLogoutRequest;
import com.a505.hobbyit.member.dto.request.MemberReissueRequest;
import com.a505.hobbyit.member.dto.request.MemberSignupRequest;
import com.a505.hobbyit.member.dto.response.MemberResponse;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    void signUp(MemberSignupRequest request);

    MemberResponse login(MemberLoginRequest request);

    void reissue(MemberReissueRequest reissue);

    ResponseEntity<?> logout(MemberLogoutRequest logout);

    ResponseEntity<?> authority();
}
