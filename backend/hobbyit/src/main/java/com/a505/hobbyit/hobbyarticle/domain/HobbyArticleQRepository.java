package com.a505.hobbyit.hobbyarticle.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbyArticleQRepository {
     Slice<HobbyArticle> findHobbyArticle(Long storedId, Long hobbyId, Pageable pageable);
}
