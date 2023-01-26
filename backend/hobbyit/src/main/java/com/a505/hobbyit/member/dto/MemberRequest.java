package com.a505.hobbyit.member.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberRequest {


    public static class Reissue {
        @NotNull(message = "accessToken 을 입력해주세요.")
        private String accessToken;

        @NotNull(message = "refreshToken 을 입력해주세요.")
        private String refreshToken;
    }

    public static class Logout {
        @NotNull(message = "잘못된 요청입니다.")
        private String accessToken;

        @NotNull(message = "잘못된 요청입니다.")
        private String refreshToken;
    }
}
