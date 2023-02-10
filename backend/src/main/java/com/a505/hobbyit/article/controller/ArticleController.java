package com.a505.hobbyit.article.controller;

import com.a505.hobbyit.article.dto.ArticleRequest;
import com.a505.hobbyit.article.dto.ArticleResponse;
import com.a505.hobbyit.article.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Article API", description = "홍보 게시판 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/article")
public class ArticleController {

    private final ArticleService articleService;


    @Operation(
            summary = "홍보 게시판 게시글 등록",
            description = "로그인 사용자 정보, 홍보할 소모임 ID, 작성할 내용을 이용하여 게시글을 등록합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "게시글 등록 성공"),
            @ApiResponse(responseCode = "401", description = "게시글 작성 권한이 없음"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근")
    })
    @PostMapping("/{hobby-id}")
    ResponseEntity<Void> createArticle(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable(value = "hobby-id") @Parameter(description = "홍보할 모임 ID") Long hobbyId,
            @RequestBody @Parameter(description = "게시할 글의 정보") ArticleRequest articleRequest) {
        articleService.save(Long.parseLong(userDetails.getUsername()), hobbyId, articleRequest);
        return ResponseEntity.ok().build();
    }


    @Operation(
            summary = "홍보 게시판 게시글 페이지 조회",
            description = "각 페이지 당 10개씩 글을 조회합니다."
    )
    @ApiResponse(responseCode = "200", description = "게시글 페이지 반환 성공")
    @GetMapping
    ResponseEntity<Page<ArticleResponse>> findArticlesByPageRequest(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ArticleResponse> articleResponsePage = articleService.findArticlesByPageRequest(pageable);
        return ResponseEntity.ok(articleResponsePage);
    }


    @Operation(
            summary = "홍보 게시판 게시글 상세 조회",
            description = "조회할 글의 ID를 이용하여 게시글을 상세 조회합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "게시글 상세 조회 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근")
    })
    @GetMapping("/{article-id}")
    ResponseEntity<ArticleResponse> findArticle(
            @PathVariable(value = "article-id") @Parameter(description = "조회할 글의 ID") Long articleId,
            HttpServletRequest request, HttpServletResponse response) {
        ArticleResponse articleResponse = articleService.findById(articleId, request, response);
        return ResponseEntity.ok(articleResponse);
    }


    @Operation(
            summary = "홍보 게시판 게시글 수정",
            description = "로그인 사용자 정보, 수정할 글의 ID, 수정할 내용을 이용하여 게시글을 수정합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "게시글 수정 성공"),
            @ApiResponse(responseCode = "401", description = "게시글 수정 권한이 없음"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근")
    })
    @PutMapping("/{article-id}")
    ResponseEntity<Void> updateArticle(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable(value = "article-id") @Parameter(description = "수정할 글의 id") Long articleId,
            @RequestBody @Parameter(description = "수정할 글의 정보") ArticleRequest articleRequest) {
        articleService.update(Long.parseLong(userDetails.getUsername()), articleId, articleRequest);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "홍보 게시판 게시글 삭제",
            description = "로그인 사용자 정보, 삭제할 글의 ID를 이용하여 게시글을 삭제합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "게시글 삭제 성공"),
            @ApiResponse(responseCode = "401", description = "게시글 삭제 권한이 없음"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근")
    })
    @DeleteMapping("/{article-id}")
    ResponseEntity<Void> deleteArticle(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable(value = "article-id") @Parameter(description = "삭제할 글의 id") Long articleId) {
        articleService.deleteById(Long.parseLong(userDetails.getUsername()), articleId);
        return ResponseEntity.noContent().build();
    }
}
