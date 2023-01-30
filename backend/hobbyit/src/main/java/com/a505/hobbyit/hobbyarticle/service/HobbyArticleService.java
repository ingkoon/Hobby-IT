package com.a505.hobbyit.hobbyarticle.service;


import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleRequest;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleUpdateRequest;

import java.util.List;

public interface HobbyArticleService {
    public List<HobbyArticleResponse> findAll(Long hobbyId);
    public void save(Long memberId, Long hobbyId, HobbyArticleRequest hobbyArticleRequest);
    public HobbyArticleResponse findById(Long articleId);
    public List<HobbyArticleResponse> findByKeyword(Long HobbyId, String keyword);
    public void update(Long articleId, HobbyArticleUpdateRequest hobbyArticleUpdateRequest);
    public void delete(Long articleId);
}