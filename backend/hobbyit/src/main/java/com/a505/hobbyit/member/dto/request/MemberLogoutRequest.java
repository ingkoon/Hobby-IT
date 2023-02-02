package com.a505.hobbyit.member.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberLogoutRequest {
    @JsonProperty("access_token")
    @NotEmpty(message = "잘못된 요청입니다.")
    private String accessToken;

//    @JsonProperty("refresh_token")
//    @NotEmpty(message = "잘못된 요청입니다.")
//    private String refreshToken;
}
