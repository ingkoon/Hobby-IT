package com.a505.hobbyit.pending.controller;


import com.a505.hobbyit.pending.dto.PendingAllowRequest;
import com.a505.hobbyit.pending.dto.PendingRequest;
import com.a505.hobbyit.pending.dto.PendingResponse;
import com.a505.hobbyit.pending.service.PendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/hobby")
@RequiredArgsConstructor
public class PendingController {

    private final PendingService pendingService;

    // 가입 신청
    @PostMapping(value = "/{hobby-id}/join")
    public ResponseEntity<String> savePendingMember(
            @RequestHeader("Authorization") final String token,
            @PathVariable("hobby-id") final long hobbyId,
            @RequestBody PendingRequest request) {
        pendingService.join(token, hobbyId, request);
        String message = "신청되었습니다.";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping(value = "/{hobby-id}/join")
    public ResponseEntity<List<PendingResponse>> findHobbyMemberList(
            @RequestHeader("Authorization") final String token,
            @PathVariable(value = "hobby-id") final Long hobbyId) {

        List<PendingResponse> pendingList = pendingService.findPendingList(token, hobbyId);
        return ResponseEntity.status(HttpStatus.OK).body(pendingList);
    }

    @PostMapping(value = "/{hobby-id}/allow")
    public ResponseEntity<Void> allowHobbyMember(
            @RequestHeader("Authorization") final String token,
            @PathVariable("hobby-id") final Long hobbyId,
            @RequestBody PendingAllowRequest request) {
        pendingService.allowPending(token, hobbyId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
