package com.a505.hobbyit.pending.controller;


import com.a505.hobbyit.pending.dto.PendingAllowRequest;
import com.a505.hobbyit.pending.dto.PendingRequest;
import com.a505.hobbyit.pending.dto.PendingResponse;
import com.a505.hobbyit.pending.service.PendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "hobby")
@RequiredArgsConstructor
public class PendingController {

    private final PendingService pendingService;

    @PostMapping(value = "/{hobby}/join")
    public ResponseEntity<String> savePendingMember(@RequestBody PendingRequest request){
//        pendingService.save();
        return ResponseEntity.ok().body("신청되었습니다");
    }

    @GetMapping(value = "/{hobby-id}/join")
    public ResponseEntity<List<PendingResponse>> findHobbyMemberList(@PathVariable(value = "hobby-id") final Long hobbyId){
        List<PendingResponse> pendingList = pendingService.findPendingList(hobbyId);
        return ResponseEntity.ok().body(pendingList);
    }

    @PostMapping(value = "/{hobby-id}/allow")
    public ResponseEntity<String> allowHobbyMember(
            @RequestBody PendingAllowRequest request){
        pendingService.allowPending(request);
        return ResponseEntity.ok().body("승인되었습니다");
    }

}
