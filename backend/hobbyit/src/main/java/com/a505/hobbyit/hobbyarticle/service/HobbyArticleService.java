package com.a505.hobbyit.hobbyarticle.service;


import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleRequest;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleUpdateRequest;

import java.util.List;

public interface HobbyArticleService {
    List<HobbyArticleResponse> findAll(Long hobbyId);

    void save(Long memberId, Long hobbyId, HobbyArticleRequest hobbyArticleRequest);

    HobbyArticleResponse findById(Long articleId);

    List<HobbyArticleResponse> findByKeyword(Long HobbyId, String keyword);

    void update(Long articleId, HobbyArticleUpdateRequest hobbyArticleUpdateRequest);

    void delete(Long articleId);
}