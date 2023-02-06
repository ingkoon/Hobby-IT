package com.a505.hobbyit.member.service;

import com.a505.hobbyit.member.dto.request.*;
import com.a505.hobbyit.member.dto.response.MemberResponse;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Value;

public interface MemberService {
    void signUp(MemberSignupRequest request);

    MemberResponse login(MemberLoginRequest request);

    MemberResponse reissue(MemberReissueRequest request);

    void logout(MemberLogoutRequest request);

    void resetPassword(MemberMailRequest request, String from) throws MessagingException;
}
