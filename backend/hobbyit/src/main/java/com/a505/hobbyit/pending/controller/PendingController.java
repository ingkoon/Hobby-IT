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
    @PostMapping(value = "/{hobby}/join")
    public ResponseEntity<String> savePendingMember(@RequestBody PendingRequest request){
//        pendingService.save();
        return ResponseEntity.status(HttpStatus.OK).body("신청되었습니다");
    }

    @GetMapping(value = "/{hobby-id}/join")
    public ResponseEntity<List<PendingResponse>> findHobbyMemberList(@PathVariable(value = "hobby-id") final Long hobbyId){
        List<PendingResponse> pendingList = pendingService.findPendingList(hobbyId);
        return ResponseEntity.status(HttpStatus.OK).body(pendingList);
    }

    @PostMapping(value = "/{hobby-id}/allow")
    public ResponseEntity<String> allowHobbyMember(
            @RequestBody PendingAllowRequest request){
        pendingService.allowPending(request);
        return ResponseEntity.status(HttpStatus.OK).body("승인되었습니다");
    }

}
