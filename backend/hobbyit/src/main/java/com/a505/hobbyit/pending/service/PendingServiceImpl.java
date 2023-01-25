package com.a505.hobbyit.pending.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.pending.domain.Pending;
import com.a505.hobbyit.pending.domain.PendingRepository;
import com.a505.hobbyit.pending.dto.PendingAllowRequest;
import com.a505.hobbyit.pending.dto.PendingRequest;
import com.a505.hobbyit.pending.dto.PendingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PendingServiceImpl implements PendingService{

    private final HobbyRepository hobbyRepository;
    private final PendingRepository pendingRepository;

    @Override
    public void save(Long memberId, Long hobbyId, PendingRequest request) {
        Hobby hobby = hobbyRepository.findById(hobbyId).orElseThrow(NoSuchHobbyException::new);
//        Pending pending = request.toEntity(memberId, hobby);

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
    해당 비즈니스 로직이 수행되면 pending entity가 소멸되고 hobby member에 데이터가 추가된다.
    고로 해당 비즈니스 로직은 hobby member로 부터 만들어져야 한다.
     */
    @Override
    public void allowPending(PendingAllowRequest request) {
        pendingRepository.deleteById(request.getWaitId());
    }
}
