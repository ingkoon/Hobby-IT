package com.a505.hobbyit.hobbyarticlelike.domain;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HobbyArticleLikesRepository extends JpaRepository<HobbyArticleLike, Long> {
    boolean existsByMemberAndHobbyArticle(Member member, HobbyArticle hobbyArticle);
    void deleteByMemberAndHobbyArticle(Member member, HobbyArticle hobbyArticle);
}
