package com.a505.hobbyit.hobby.controller;

import com.a505.hobbyit.hobby.dto.HobbyMemberResponse;
import com.a505.hobbyit.hobby.dto.HobbyRequest;
import com.a505.hobbyit.hobby.dto.HobbyResponse;
import com.a505.hobbyit.hobby.service.HobbyService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/hobby")
public class HobbyController {

    private final HobbyService hobbyService;

    @PostMapping
    public ResponseEntity<Void> createHobby(
            @RequestHeader("Authorization") final String token,
            @RequestPart("multipartFile") MultipartFile multipartFile,
            @RequestPart("request") HobbyRequest requestDto){
        hobbyService.save(token, multipartFile, requestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/{hobby-id}")
    public ResponseEntity<HobbyResponse> findHobby(@PathVariable(value = "hobby-id") final Long hobbyId){
        HobbyResponse response = hobbyService.findById(hobbyId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<HobbyResponse>> findHobbies(){
        List<HobbyResponse> responses = hobbyService.findAll();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<HobbyResponse>> searchHobbies(@RequestParam(value = "category") String category,
                                                              @RequestParam(value = "keyWord") String keyWord) {
        List<HobbyResponse> responses = hobbyService.findByKeyword(keyWord);
        return ResponseEntity.ok(responses);
    }

    @GetMapping(value = "/popular")
    public ResponseEntity<List<HobbyResponse>> findPopularHobbies(){
        List<HobbyResponse> responses = hobbyService.findPopularHobby();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(value = "/fresh")
    public ResponseEntity<List<HobbyResponse>> findFreshHobbies(){
        List<HobbyResponse> responses = hobbyService.findFreshHobby();
        return ResponseEntity.ok(responses);
    }

    /*
    #18. 모임 회원 명단 확인 API
    */
    @GetMapping(value = "/{hobby-id}/member")
    public ResponseEntity<List<HobbyMemberResponse>> findHobbyMembers(@PathVariable(value = "hobby-id") Long hobbyId){
        List<HobbyMemberResponse> responses = hobbyService.findHobbyMembers(hobbyId);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @DeleteMapping(value = "/{hobby-id}")
    public ResponseEntity<Void> deleteHobby(@PathVariable(value = "hobby-id") final Long hobbyId){
        Long memberId = 1L;
        hobbyService.deleteHobby(hobbyId, memberId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
