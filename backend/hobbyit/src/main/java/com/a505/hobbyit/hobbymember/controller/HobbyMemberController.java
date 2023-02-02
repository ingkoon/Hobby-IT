package com.a505.hobbyit.hobbymember.controller;

import com.a505.hobbyit.hobbymember.dto.HobbyMemberUpdateRequest;
import com.a505.hobbyit.hobbymember.service.HobbyMemberService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/hobby")
@RequiredArgsConstructor
public class HobbyMemberController {
    private final HobbyMemberService hobbyMemberService;

    @PutMapping("/{hobby-id}/member/{member-id}")
    public ResponseEntity<Void> updateHobbyMember(
            @Parameter(description = "사용자 정보 갱신 API")
            @RequestHeader final String token,
            @PathVariable("hobby-id") final Long hobbyId,
            @PathVariable("member-id") final Long targetId,
            @RequestBody HobbyMemberUpdateRequest request) {

        hobbyMemberService.updatePrivilege(token, hobbyId, targetId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{hobby-id}/member/{member-id}")
    public ResponseEntity<Void> kickHobbyMember(
            @RequestHeader final String token,
            @PathVariable("hobby-id") final Long hobbyId,
            @PathVariable("member-id") final Long targetId) {

        hobbyMemberService.kickHobbyMember(token, hobbyId, targetId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{hobby-id}/member")
    public ResponseEntity<Void> resignHobbyMember(
            @RequestHeader final String token,
            @PathVariable("hobby-id") final Long hobbyId) {

        hobbyMemberService.resignHobbyMember(token, hobbyId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
