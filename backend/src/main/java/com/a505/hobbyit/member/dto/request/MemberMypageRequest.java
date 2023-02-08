package com.a505.hobbyit.member.dto.request;

import com.a505.hobbyit.member.domain.Member;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberMypageRequest {
    @NotNull(message = "별명은 필수 입력 사항입니다.")
    private String nickname;

    @NotNull(message = "비밀번호는 필수 입력 사항입니다.")
    private String password;

    private String imgUrl;

    private String intro;

    public Member toEntity() {
        return Member.builder()
                .nickname(nickname)
                .password(password)
                .imgUrl(imgUrl)
                .intro(intro)
                .build();
    }
}
