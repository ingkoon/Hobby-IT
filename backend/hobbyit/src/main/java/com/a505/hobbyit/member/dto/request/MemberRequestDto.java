package com.a505.hobbyit.member.dto.request;

import com.a505.hobbyit.member.domain.Member;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class MemberRequestDto {
    @AllArgsConstructor
    @Getter
    public static class Reissue {
        @NotEmpty(message = "accessToken 을 입력해주세요.")
        private String accessToken;

        @NotEmpty(message = "refreshToken 을 입력해주세요.")
        private String refreshToken;
    }
    @AllArgsConstructor
    @Getter
    public static class Logout {
        @NotEmpty(message = "잘못된 요청입니다.")
        private String accessToken;

        @NotEmpty(message = "잘못된 요청입니다.")
        private String refreshToken;
    }
}
