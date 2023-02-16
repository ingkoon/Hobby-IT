package com.a505.hobbyit.hobbymember.controller;

import com.a505.hobbyit.hobbymember.dto.HobbyMemberUpdateRequest;
import com.a505.hobbyit.article.dto.OwnHobbyResponse;
import com.a505.hobbyit.hobbymember.service.HobbyMemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/hobby")
@RequiredArgsConstructor
public class HobbyMemberController {
    private final HobbyMemberService hobbyMemberService;
    @PutMapping("/{hobby-id}/member/{member-id}")
    public ResponseEntity<Void> updateHobbyMember(
            @Parameter(description = "사용자 정보 갱신 API")
            @PathVariable("hobby-id") final Long hobbyId,
            @PathVariable("member-id") final Long targetId,
            @RequestBody HobbyMemberUpdateRequest request){

        hobbyMemberService.updatePrivilege(hobbyId, targetId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{hobby-id}/member/{member-id}")
    public ResponseEntity<Void> kickHobbyMember(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @PathVariable("member-id") final Long targetId ){

        hobbyMemberService.kickHobbyMember(userDetails.getUsername(), hobbyId, targetId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{hobby-id}/member")
    public ResponseEntity<Void> resignHobbyMember(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId){

        hobbyMemberService.resignHobbyMember(userDetails.getUsername(), hobbyId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
