package com.a505.hobbyit.hobbyarticle.domain;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbyArticleQRepository {
     Slice<HobbyArticleResponse> findHobbyArticle(Long storedId, Hobby hobby, Pageable pageable);
     Slice<HobbyArticleResponse> searchHobbyArticle(Long storedId, String keyword, Hobby hobby, Pageable pageable);
     Page<HobbyArticleResponse> findHobbyNotice(Hobby hobby,Pageable pageable);
     Page<HobbyArticleResponse> searchHobbyNotice(Hobby hobby,String keyword, Pageable pageable);
}
