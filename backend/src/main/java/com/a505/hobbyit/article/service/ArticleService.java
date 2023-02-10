package com.a505.hobbyit.article.service;

import com.a505.hobbyit.article.dto.ArticleRequest;
import com.a505.hobbyit.article.dto.ArticleResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

public interface ArticleService {

    void save(Long memberId, Long hobbyId, ArticleRequest articleRequest);

    Page<ArticleResponse> findArticlesByPageRequest(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable);

    ArticleResponse findById(Long articleId, HttpServletRequest request, HttpServletResponse response);

    void update(Long memberId, Long articleId, ArticleRequest articleRequest);

    void deleteById(Long memberId, Long articleId);
}
