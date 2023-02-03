package com.a505.hobbyit.hobbyarticle.controller;

import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleDetailResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleUpdateRequest;
import com.a505.hobbyit.hobbyarticle.service.HobbyArticleService;
import io.swagger.v3.oas.annotations.headers.Header;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/hobby")
public class HobbyArticleController {

    private final HobbyArticleService hobbyArticleService;


    @GetMapping(value = "/{hobby-id}/article")
    public ResponseEntity<HobbyArticleResponse> getArticleList(
            @RequestHeader String token,
            @PathVariable final Long hobbyId,
            @RequestParam final int size
    ){  hobbyArticleService.findAll(token, hobbyId, size);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*
    # 30. 모임 게시판 게시글 조회
    */
    @GetMapping(value = "/{hobby-id}/article/{article-id}")
    public ResponseEntity<HobbyArticleDetailResponse> getArticle(
            @RequestHeader("Authorization") final String token,
            @PathVariable("hobby-id") final Long hobbyId,
            @RequestParam("article-id") final Long articleId){
        HobbyArticleDetailResponse response = hobbyArticleService.findById(token, hobbyId, articleId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping(value = "/{hobby-id}/article/{article-id}")
    public ResponseEntity<Void> updateArticle(
            @PathVariable("hobby-id") final Long hobbyId,
            @RequestParam("article-id") final Long articleId,
            @RequestBody HobbyArticleUpdateRequest request) {
        hobbyArticleService.update(articleId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
