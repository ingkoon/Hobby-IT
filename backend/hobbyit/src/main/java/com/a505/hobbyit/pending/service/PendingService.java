package com.a505.hobbyit.pending.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.pending.dto.PendingAllowRequest;
import com.a505.hobbyit.pending.dto.PendingRequest;
import com.a505.hobbyit.pending.dto.PendingResponse;

import java.util.List;

public interface PendingService {
    void join(final String token, Long hobbyId, PendingRequest request);

    List<PendingResponse> findPendingList(final String token, Long hobbyId);

    void allowPending(final String token, final Long hobbyId, PendingAllowRequest request);

    Hobby checkPrivilege(Long hobbyId, String token);
}
