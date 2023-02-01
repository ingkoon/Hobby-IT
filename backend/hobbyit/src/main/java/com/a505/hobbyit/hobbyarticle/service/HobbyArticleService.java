package com.a505.hobbyit.hobbyarticle.service;


import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleRequest;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleUpdateRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HobbyArticleService {
    public List<HobbyArticleResponse> findAll(Long hobbyId);
    public void save(String token, Long hobbyId, HobbyArticleRequest hobbyArticleRequest, List<MultipartFile> files);
    public HobbyArticleResponse findById(Long articleId);
    public List<HobbyArticleResponse> findByKeyword(Long HobbyId, String keyword);
    public void update(Long articleId, HobbyArticleUpdateRequest hobbyArticleUpdateRequest);
    public void delete(Long articleId);
}