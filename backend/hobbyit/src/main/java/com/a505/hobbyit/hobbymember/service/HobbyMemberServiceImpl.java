package com.a505.hobbyit.hobbymember.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.domain.HobbyMemberRepository;
import com.a505.hobbyit.hobbymember.dto.HobbyMemberUpdateRequest;
import com.a505.hobbyit.hobbymember.exception.NoSuchHobbyMemberException;
import com.a505.hobbyit.jwt.JwtTokenProvider;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HobbyMemberServiceImpl implements HobbyMemberService{

    private final MemberRepository memberRepository;
    private final HobbyRepository hobbyRepository;
    private final HobbyMemberRepository hobbyMemberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    @Override
    public void updatePrivilege(String token, Long hobbyId, Long targetId, HobbyMemberUpdateRequest request) {
        checkPrivilege(hobbyId, token);

        HobbyMember hobbyMember = hobbyMemberRepository
                .findById(targetId)
                .orElseThrow(NoSuchHobbyMemberException::new);

        hobbyMember.updatePrivilege(request.getPrivilege());

    }
    @Transactional
    @Override
    public void kickHobbyMember(String token, Long hobbyId, Long targetId) {
        checkPrivilege(hobbyId, token);

        HobbyMember hobbyMember = hobbyMemberRepository
                .findById(targetId)
                .orElseThrow(NoSuchHobbyMemberException::new);

        hobbyMemberRepository.delete(hobbyMember);
    }

    @Transactional
    @Override
    public void resignHobbyMember(String token, Long hobbyId) {
        String memberEmail = jwtTokenProvider.getUser(token);

        Member member = memberRepository
                .findByEmail(memberEmail)
                .orElseThrow(NoSuchElementException::new);

        Hobby hobby = hobbyRepository
                .findById(hobbyId)
                .orElseThrow(NoSuchHobbyException::new);

        HobbyMember hobbyMember = hobbyMemberRepository
                .findByMemberAndHobby(member, hobby)
                .orElseThrow(NoSuchHobbyMemberException::new);

        hobbyMemberRepository.delete(hobbyMember);
    }

    @Override
    public Hobby checkPrivilege(Long hobbyId, String token){
        String memberEmail = jwtTokenProvider.getUser(token);
        Member member = memberRepository
                .findByEmail(memberEmail)
                .orElseThrow(NoSuchElementException::new);
        Hobby hobby = hobbyRepository
                .findById(hobbyId)
                .orElseThrow(NoSuchHobbyException::new);
        hobbyMemberRepository
                .findByMemberAndHobby(member, hobby)
                .orElseThrow(NoSuchHobbyMemberException::new)
                .checkPrivilege();
        return hobby;
    }
}
