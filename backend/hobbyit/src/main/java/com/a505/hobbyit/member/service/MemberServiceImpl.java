package com.a505.hobbyit.member.service;

import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.dto.request.*;
import com.a505.hobbyit.member.dto.response.MemberResponse;
import com.a505.hobbyit.member.enums.MemberPrivilege;
import com.a505.hobbyit.jwt.JwtTokenProvider;
import com.a505.hobbyit.member.exception.*;
import com.a505.hobbyit.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public void signUp(MemberSignupRequest request) {
        if (memberRepository.existsByEmail(request.getEmail())) {
            throw new DuplicatedMemberException();
        }

        if (memberRepository.existsByNickname(request.getNickname())) {
            throw new DuplicatedMemberException("중복된 닉네임입니다.");
        }

        Member member = Member.builder()
                .email(request.getEmail())
                .name(request.getName())
                .nickname(request.getNickname())
                .password(passwordEncoder.encode(request.getPassword()))
                .privilege(Collections.singleton(MemberPrivilege.GENERAL.name()))
                .build();
        memberRepository.save(member);
    }

    public MemberResponse login(MemberLoginRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail()).orElseThrow(NoSuchElementException::new);

        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = request.toAuthentication();

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        MemberResponse tokenInfo = jwtTokenProvider.generateToken(authentication, member);

        // 4. RefreshToken Redis 저장 (expirationTime 설정을 통해 자동 삭제 처리)
        stringRedisTemplate.opsForValue()
                .set("RT:" + authentication.getName(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

        return tokenInfo;
    }

    public MemberResponse reissue(MemberReissueRequest request) {
        // 1. Refresh Token 검증
        if (!jwtTokenProvider.validateToken(request.getRefreshToken())) {
            throw new InvalidedRefreshTokenException();
        }

        // 2. Access Token 에서 Member email 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(request.getAccessToken());

        Member member = memberRepository.findByEmail(authentication.getName()).orElseThrow(NoSuchElementException::new);

        // 3. Redis 에서 Member email 을 기반으로 저장된 Refresh Token 값을 가져옵니다.
        String refreshToken = stringRedisTemplate.opsForValue().get("RT:" + authentication.getName());
        // 로그아웃되어 Redis 에 RefreshToken 이 존재하지 않는 경우 처리
        if (ObjectUtils.isEmpty(refreshToken)) {
            throw new InvalidedRefreshTokenException("Refresh Token 이 없습니다.");
        }
        if (!refreshToken.equals(request.getRefreshToken())) {
            throw new InvalidedRefreshTokenException("Refresh Token 정보가 일치하지 않습니다.");
        }

        // 4. 새로운 토큰 생성
        MemberResponse tokenInfo = jwtTokenProvider.generateToken(authentication, member);

        // 5. RefreshToken Redis 업데이트
        stringRedisTemplate.opsForValue()
                .set("RT:" + authentication.getName(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

        return tokenInfo;
    }

    public void logout(MemberLogoutRequest request) {
        // 1. Access Token 검증
        if (!jwtTokenProvider.validateToken(request.getAccessToken())) {
            throw new InvalidedAccessTokenException();
        }

        // 2. Access Token 에서 Member email 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(request.getAccessToken());

        // 3. Redis 에서 해당 Member email 로 저장된 Refresh Token 이 있는지 여부를 확인 후 있을 경우 삭제합니다.
        if (stringRedisTemplate.opsForValue().get("RT:" + authentication.getName()) != null) {
            // Refresh Token 삭제
            stringRedisTemplate.delete("RT:" + authentication.getName());
        }

        // 4. 해당 Access Token 유효시간 가지고 와서 BlackList 로 저장하기
        Long expiration = jwtTokenProvider.getExpiration(request.getAccessToken());
        stringRedisTemplate.opsForValue()
                .set(request.getAccessToken(), "logout", expiration, TimeUnit.MILLISECONDS);
    }

    @Override
    public void resetPassword(MemberMailRequest request) {
        String email = memberRepository.findByEmailAndName(request.getEmail(), request.getName());
        if(email == null)
            throw new NoSuchMemberException();

    }

}
