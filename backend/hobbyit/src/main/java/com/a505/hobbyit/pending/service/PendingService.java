package com.a505.hobbyit.pending.service;

import com.a505.hobbyit.pending.dto.PendingAllowRequest;
import com.a505.hobbyit.pending.dto.PendingRequest;
import com.a505.hobbyit.pending.dto.PendingResponse;

import java.util.List;

public interface PendingService {
    public void save(Long memberId, Long hobbyId, PendingRequest request);
    public List<PendingResponse> findPendingList(Long hobbyId);
    public void allowPending(PendingAllowRequest request);

}
