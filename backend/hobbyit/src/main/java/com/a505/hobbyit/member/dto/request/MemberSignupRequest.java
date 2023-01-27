package com.a505.hobbyit.member.dto;

import com.a505.hobbyit.member.domain.Member;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberSignupRequest {

    @NotNull(message = "이메일은 필수 입력값입니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    private String email;

    @NotNull(message = "이름은 필수 입력값입니다.")
    private String name;

    @NotNull(message = "별명은 필수 입력값입니다.")
    private String nickname;

    @NotNull(message = "비밀번호는 필수 입력값입니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    public Member toEntity(){
        return Member.builder().email(email)
                .name(name)
                .nickname(nickname)
                .password(password)
                .build();
    }
}
