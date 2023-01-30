package com.a505.hobbyit.pending.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.domain.HobbyMemberRepository;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberState;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import com.a505.hobbyit.pending.domain.Pending;
import com.a505.hobbyit.pending.domain.PendingRepository;
import com.a505.hobbyit.pending.dto.PendingAllowRequest;
import com.a505.hobbyit.pending.dto.PendingRequest;
import com.a505.hobbyit.pending.dto.PendingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PendingServiceImpl implements PendingService{

    private final HobbyRepository hobbyRepository;
    private final MemberRepository memberRepository;
    private final HobbyMemberRepository hobbyMemberRepository;
    private final PendingRepository pendingRepository;

    @Transactional
    @Override
    public void save(Long memberId, Long hobbyId, PendingRequest request) {
        Member findMember = memberRepository.findById(memberId).orElseThrow(NoSuchElementException::new);
        Hobby findHobby = hobbyRepository.findById(hobbyId).orElseThrow(NoSuchHobbyException::new);
        Pending pending = request.toEntity(findMember, findHobby);

        pendingRepository.save(pending);
    }

    @Override
    public List<PendingResponse> findPendingList(Long hobbyId) {
        Hobby hobby = hobbyRepository
                .findById(hobbyId)
                .orElseThrow(NoSuchHobbyException::new);

        List<Pending> pendings = hobby.getPendings();
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
    public void allowPending(PendingAllowRequest request) {
        Pending pending = pendingRepository.findById(request.getWaitId()).orElseThrow(NoSuchElementException::new);

        Member findMember = pending.getMember();
        Hobby findHobby = pending.getHobby();


        HobbyMember hobbyMember = HobbyMember.builder()
                .member(findMember)
                .hobby(findHobby)
                .state(HobbyMemberState.ACTIVE)
                .enrollDate(LocalDateTime.now())
                .privilege(HobbyMemberPrivilege.GENERAL)
                .build();

        hobbyMemberRepository.save(hobbyMember);
        pendingRepository.deleteById(request.getWaitId());
    }
}
