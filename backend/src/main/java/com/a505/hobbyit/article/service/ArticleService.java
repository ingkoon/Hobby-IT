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

    void save(String token, Long hobbyId, ArticleRequest articleRequest);

    Page<ArticleResponse> findArticlesByPageRequest(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable);

    ArticleResponse findById(Long articleId, HttpServletRequest request, HttpServletResponse response);

    void update(String token, Long articleId, ArticleRequest articleRequest);

    void deleteById(String token, Long articleId);
}
