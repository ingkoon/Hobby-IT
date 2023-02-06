package com.a505.hobbyit.hobbyarticle.service;


import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleDetailResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleRequest;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleUpdateRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HobbyArticleService {
    public List<HobbyArticleResponse> findAll(String token, Long hobbyId, int size);
    public void save(String token, Long hobbyId, HobbyArticleRequest hobbyArticleRequest, List<MultipartFile> files);
    public HobbyArticleDetailResponse findById(final String token , final Long hobbyId, final Long articleId);
    public List<HobbyArticleResponse> findByKeyword(Long HobbyId, String keyword);
    public void update(final Long articleId, HobbyArticleUpdateRequest request);
    public void delete(Long articleId);
}