package com.a505.hobbyit.member.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberReissueRequest {
    @JsonProperty("access_token")
    @NotEmpty(message = "accessToken 을 입력해주세요.")
    private String accessToken;

    @JsonProperty("refresh_token")
    @NotEmpty(message = "refreshToken 을 입력해주세요.")
    private String refreshToken;

}
