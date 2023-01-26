package com.a505.hobbyit.member.dto;

import com.a505.hobbyit.member.domain.Member;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberReissueRequest {

    @NotNull(message = "accessToken 을 입력해주세요.")
    private String accessToken;

    @NotNull(message = "refreshToken 을 입력해주세요.")
    private String refreshToken;

    public Member toEntity() {
        return Member.builder().
    }
}
