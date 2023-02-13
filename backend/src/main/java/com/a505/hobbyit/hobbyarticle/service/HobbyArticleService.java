package com.a505.hobbyit.hobbyarticle.service;


import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleDetailResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleRequest;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HobbyArticleService {
    public Slice<HobbyArticleResponse> findAll(String memberId, Long storedId, Long hobbyId, Pageable pageable);
    public Slice<HobbyArticleResponse> findByKeyword(String memberId, Long storedId, String keyword, final Long hobbyId, Pageable pageable);
    public Page<HobbyArticleResponse> findAllNotice(String memberId, final Long hobbyId, Pageable pageable);
    public Page<HobbyArticleResponse> findNoticeByKeyWord(String memberId, final Long hobbyId, String keyword, Pageable pageable);
    public void save(String memberId, Long hobbyId, HobbyArticleRequest hobbyArticleRequest, List<MultipartFile> files);
    public HobbyArticleDetailResponse findById(String memberId, final Long hobbyId, final Long articleId);
    public void update(String memberId, final Long articleId, HobbyArticleUpdateRequest request);
    public void delete(String memberId, Long hobbyId, Long articleId);
}