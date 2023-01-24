package com.a505.hobbyit.hobby.controller;

import com.a505.hobbyit.hobby.dto.HobbyRequest;
import com.a505.hobbyit.hobby.dto.HobbyResponse;
import com.a505.hobbyit.hobby.service.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/hobby")
public class HobbyController {

    private final HobbyService hobbyService;

    @PostMapping
    public ResponseEntity<HobbyResponse> createHobby(@RequestBody HobbyRequest request){
        HobbyResponse response = hobbyService.save(request);
        return ResponseEntity.ok().body(response);
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
        List<HobbyResponse> responses = hobbyService.findByKeyword(category, keyWord);
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
}
