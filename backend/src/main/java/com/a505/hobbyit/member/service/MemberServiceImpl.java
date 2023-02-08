package com.a505.hobbyit.member.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.dto.request.*;
import com.a505.hobbyit.member.dto.response.MemberHobbyResponse;
import com.a505.hobbyit.member.dto.response.MemberPendingResponse;
import com.a505.hobbyit.member.dto.response.MemberResponse;
import com.a505.hobbyit.member.dto.response.MypageResponse;
import com.a505.hobbyit.member.enums.MemberPrivilege;
import com.a505.hobbyit.jwt.JwtTokenProvider;
import com.a505.hobbyit.member.exception.*;
import com.a505.hobbyit.member.domain.MemberRepository;
import com.a505.hobbyit.pending.domain.Pending;
import com.a505.hobbyit.security.SecurityUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;
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
    private final JavaMailSender javaMailSender;
    private final HobbyRepository hobbyRepository;
    private final SecurityUtil securityUtil;

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

    @Override
    public MemberResponse login(MemberLoginRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail()).orElseThrow(NoSuchElementException::new);

        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = request.toAuthentication();

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        MemberResponse tokenInfo = jwtTokenProvider.generateToken(authentication, member, true, "");

        // 4. RefreshToken Redis 저장 (expirationTime 설정을 통해 자동 삭제 처리)
        stringRedisTemplate.opsForValue()
                .set("RT:" + member.getId(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

        return tokenInfo;
    }

    @Override
    public MemberResponse reissue(MemberReissueRequest request) {
        // 1. Refresh Token 검증
        if (!jwtTokenProvider.validateToken(request.getRefreshToken())) {
            throw new InvalidedRefreshTokenException();
        }

        // 2. Refresh Token 에서 Member id 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(request.getRefreshToken());

        Member member = memberRepository.findById(Long.parseLong(authentication.getName())).orElseThrow(NoSuchElementException::new);

        // 3. Redis 에서 Member id 를 기반으로 저장된 Refresh Token 값을 가져옵니다.
        String refreshToken = stringRedisTemplate.opsForValue().get("RT:" + member.getId());

        // 로그아웃되어 Redis 에 RefreshToken 이 존재하지 않는 경우 처리
        if (ObjectUtils.isEmpty(refreshToken)) {
            throw new InvalidedRefreshTokenException("로그아웃 상태입니다.");
        }
        if (!refreshToken.equals(request.getRefreshToken())) {
            throw new InvalidedRefreshTokenException("Refresh Token 정보가 일치하지 않습니다.");
        }

        // 4. 새로운 토큰 생성
        MemberResponse tokenInfo = jwtTokenProvider.generateToken(authentication, member, false, request.getRefreshToken());

        // 5. RefreshToken Redis 업데이트
        stringRedisTemplate.opsForValue()
                .set("RT:" + authentication.getName(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

        return tokenInfo;
    }

    @Override
    public void logout(final String token) {
        String accessToken = token.split(" ")[1];

        // 1. Access Token 검증
        if (!jwtTokenProvider.validateToken(accessToken)) {
            throw new InvalidedAccessTokenException();
        }

        // 2. Access Token 에서 Member email 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(accessToken);

        // 3. Redis 에서 해당 Member email 로 저장된 Refresh Token 이 있는지 여부를 확인 후 있을 경우 삭제합니다.
        if (stringRedisTemplate.opsForValue().get("RT:" + authentication.getName()) != null) {
            // Refresh Token 삭제
            stringRedisTemplate.delete("RT:" + authentication.getName());
        }

        // 4. 해당 Access Token 유효시간 가지고 와서 BlackList 로 저장하기
        Long expiration = jwtTokenProvider.getExpiration(token);
        stringRedisTemplate.opsForValue().set(accessToken, "logout", expiration, TimeUnit.MILLISECONDS);
    }

    @Transactional
    @Override
    public void resetPassword(MemberMailRequest request, String from) throws MessagingException {
        // 1. 입력된 이메일과 본명을 동시에 만족하는 사용자가 존재하는지 확인
        Member member = memberRepository.findByEmailAndName(request.getEmail(), request.getName()).orElseThrow(NoSuchMemberException::new);

        // 2. 랜덤으로 비밀번호를 생성해서 비밀번호 자동 변경
        char[] charSet = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String pwd = "";
        for (int i = 0, idx = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            pwd += charSet[idx];
        }

        member.resetPassword(passwordEncoder.encode(pwd));

        // 3. 이메일로 보낼 메일 내용을 작성하는 부분
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // true는 멀티파트 메세지를 사용하겠다는 의미
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(request.getEmail());
        mimeMessageHelper.setSubject("HOBBY'IT 임시비밀번호 안내 이메일 입니다.");
        // true는 html을 사용하겠다는 의미
        mimeMessageHelper.setText("안녕하세요. HOBBY'IT 임시비밀번호 안내 관련 이메일 입니다.<br> " + " 회원님의 임시 비밀번호는 <b>"
                + pwd + "</b> 입니다.<br> " + "로그인 후에 비밀번호를 변경을 해주세요.", true);
//        mimeMessageHelper.addInline("logo", new FileDataSource("C:/Users/KANG/Desktop/logo.png"));
        javaMailSender.send(mimeMessage);
    }

    @Override
    public MypageResponse findMypage(final String token, final String nickname) {
//        System.out.println(securityUtil.getCurrentMemberEmail());
        String id = jwtTokenProvider.getUser(token);

        Member member = memberRepository.findByNickname(nickname)
                .orElseThrow(NoSuchMemberException::new);

        MypageResponse mypageResponse;
        if (memberRepository.existsByIdAndNickname(id, nickname)) {
            mypageResponse = MypageResponse.builder()
                    .email(member.getEmail())
                    .name(member.getName())
                    .nickname(member.getNickname())
                    .intro(member.getIntro())
                    .point(member.getPoint())
                    .imgUrl(member.getImgUrl())
                    .build();
        } else {
            mypageResponse = MypageResponse.builder()
                    .nickname(member.getNickname())
                    .intro(member.getIntro())
                    .point(member.getPoint())
                    .imgUrl(member.getImgUrl())
                    .build();
        }

        return mypageResponse;
    }

    @Transactional
    @Override
    public void update(final String token, MemberMypageRequest request) {
        Member member = memberRepository.findById(Long.parseLong(jwtTokenProvider.getUser(token)))
                .orElseThrow(NoSuchMemberException::new);
        member.updateMember(request);
        member.resetPassword(passwordEncoder.encode(request.getPassword()));
    }

    @Override
    public List<MemberHobbyResponse> getHobbyList(final String token) {
        String id = jwtTokenProvider.getUser(token);
        Member member = memberRepository.findById(Long.parseLong(id)).orElseThrow(NoSuchMemberException::new);

        List<HobbyMember> hobbyMembers = member.getHobbyMembers();

        List<MemberHobbyResponse> responses = new ArrayList<>();
        for (HobbyMember hobbyMember : hobbyMembers) {
            Hobby hobby = hobbyRepository.findById(hobbyMember.getHobby().getId()).orElseThrow(NoSuchHobbyException::new);
            MemberHobbyResponse response = new MemberHobbyResponse().of(hobby);
            responses.add(response);
        }

        return responses;
    }

    @Override
    public List<MemberPendingResponse> getPendingList(final String token) {
        String id = jwtTokenProvider.getUser(token);
        Member member = memberRepository.findById(Long.parseLong(id)).orElseThrow(NoSuchMemberException::new);

        List<Pending> pendings = member.getPendings();

        List<MemberPendingResponse> responses = new ArrayList<>();
        for (Pending pending : pendings) {
            Hobby hobby = hobbyRepository.findById(pending.getHobby().getId()).orElseThrow(NoSuchHobbyException::new);
            MemberPendingResponse response = new MemberPendingResponse().of(hobby);
            responses.add(response);
        }

        return responses;
    }

}
