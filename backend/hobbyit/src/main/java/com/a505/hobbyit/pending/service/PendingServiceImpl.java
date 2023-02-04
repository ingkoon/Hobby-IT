package com.a505.hobbyit.pending.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.enums.HobbyFree;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.domain.HobbyMemberRepository;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberState;
import com.a505.hobbyit.hobbymember.exception.NoSuchHobbyMemberException;
import com.a505.hobbyit.jwt.JwtTokenProvider;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import com.a505.hobbyit.member.exception.InvalidedRefreshTokenException;
import com.a505.hobbyit.pending.DuplicatedPendingException;
import com.a505.hobbyit.pending.domain.Pending;
import com.a505.hobbyit.pending.domain.PendingRepository;
import com.a505.hobbyit.pending.dto.PendingAllowRequest;
import com.a505.hobbyit.pending.dto.PendingRequest;
import com.a505.hobbyit.pending.dto.PendingResponse;
import com.a505.hobbyit.pending.enums.PendingAllow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PendingServiceImpl implements PendingService{

    private final HobbyRepository hobbyRepository;
    private final MemberRepository memberRepository;
    private final HobbyMemberRepository hobbyMemberRepository;
    private final PendingRepository pendingRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    @Override
    public void join(final String token, Long hobbyId, PendingRequest request) {
        String memberEmail = jwtTokenProvider.getUser(token);
        Member member = memberRepository.findByEmail(memberEmail).orElseThrow(InvalidedRefreshTokenException::new);
        Hobby hobby = hobbyRepository.findById(hobbyId).orElseThrow(NoSuchHobbyException::new);

        if(pendingRepository.existsByMemberAndHobby(member, hobby) || hobbyMemberRepository.existsByMemberAndHobby(member, hobby))
            throw new DuplicatedPendingException();

        if(hobby.getFree().equals(HobbyFree.FREE)){
            HobbyMember hobbyMember = new HobbyMember().ofGeneral(member, hobby);
            hobbyMemberRepository.save(hobbyMember);
            return;
        }

        Pending pending = request.toEntity(member, hobby);

        log.info(pending.toString());
        pendingRepository.save(pending);
    }

    @Override
    public List<PendingResponse> findPendingList(final String token, Long hobbyId) {
        Hobby hobby = checkPrivilege(hobbyId, token);

        List<Pending> pendings = pendingRepository
                .getAllByHobbyAndPendingAllow(hobby, PendingAllow.WAITING);

        log.info(pendings.size()+"");
        List<PendingResponse> responses = new ArrayList<>();
        for (Pending pending : pendings) {
            PendingResponse response = new PendingResponse().of(pending);
            responses.add(response);
        }

        return responses;
    }
    /*
    # 23 가입 신청 검증
    해당 비즈니스 로직이 수행되면 pending entity가 소멸되고 hobby member에 데이터가 추가된다.
    고로 해당 비즈니스 로직은 hobby member로 부터 만들어져야 한다.
    ------
    여기서 처리해도 될 것 같다.
     */
    @Transactional
    @Override
    public void allowPending(final String token, final Long hobbyId, PendingAllowRequest request) {
       checkPrivilege(hobbyId, token);

        Pending pending = pendingRepository
                .findById(request.getWaitId())
                .orElseThrow(NoSuchElementException::new);

        pending.updatePendingAllow(request.getIsAllowed());
        if(request.getIsAllowed().equals(PendingAllow.REJECTED)) return;

        Member findMember = pending.getMember();
        Hobby findHobby = pending.getHobby();

        HobbyMember hobbyMember = HobbyMember.builder()
                .member(findMember)
                .hobby(findHobby)
                .state(HobbyMemberState.ACTIVE)
                .privilege(HobbyMemberPrivilege.GENERAL)
                .build();

        hobbyMemberRepository.save(hobbyMember);
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