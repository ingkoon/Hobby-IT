//package com.a505.hobbyit.member.dto.request;
//
//import com.a505.hobbyit.member.domain.Member;
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//
//import jakarta.validation.constraints.Pattern;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//public class MemberRequest {
//
////    @NotNull(message = "이메일이 Null일 수 없습니다.")
////    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
//    private String email;
//
//    @NotNull(message = "이름이 Null일 수 없습니다.")
//    private String name;
//
//    @NotNull(message = "별명이 Null일 수 없습니다.")
//    private String nickname;
//
////    @NotNull(message = "비밀번호가 Null일 수 없습니다.")
////    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
//    private String password;
//
//    private String intro;
//
//    private String profile_img;
//
//    public UsernamePasswordAuthenticationToken toAuthentication() {
//        return new UsernamePasswordAuthenticationToken(email, password);
//    }
//
//    private String accessToken;
//
//    private String refreshToken;
//
//    public Member toSignupEntity(){
//        return Member.builder().email(email)
//                .name(name)
//                .nickname(nickname)
//                .password(password)
//                .build();
//    }
//
//    public Member toLoginEntity(){
//        return Member.builder().email(email)
//                .password(password)
//                .build();
//    }
//}
