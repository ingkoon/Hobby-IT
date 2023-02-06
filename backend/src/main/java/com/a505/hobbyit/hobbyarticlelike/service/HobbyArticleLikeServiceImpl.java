package com.a505.hobbyit.hobbyarticlelike.service;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticleRepository;
import com.a505.hobbyit.hobbyarticle.exception.NoSuchHobbyArticleException;
import com.a505.hobbyit.hobbyarticlelike.domain.HobbyArticleLike;
import com.a505.hobbyit.hobbyarticlelike.domain.HobbyArticleLikesRepository;
import com.a505.hobbyit.jwt.JwtTokenProvider;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HobbyArticleLikeServiceImpl implements HobbyArticleLikeService{

    private final HobbyArticleLikesRepository hobbyArticleLikesRepository;
    private final MemberRepository memberRepository;
    private final HobbyArticleRepository hobbyArticleRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void like(String token, Long articleId) {
        String memberEmail = jwtTokenProvider.getUser(token);
        Member member = memberRepository
                .findByEmail(memberEmail)
                .orElseThrow(NoSuchElementException::new);
        HobbyArticle hobbyArticle = hobbyArticleRepository
                .findById(articleId)
                .orElseThrow(NoSuchHobbyArticleException::new);
        if(hobbyArticleLikesRepository.existsByMemberAndHobbyArticle(member, hobbyArticle))
        {
            hobbyArticleLikesRepository.deleteByMemberAndHobbyArticle(member, hobbyArticle);
            return;
        }
        HobbyArticleLike hobbyArticleLike = HobbyArticleLike
                .builder()
                .member(member)
                .hobbyArticle(hobbyArticle)
                .build();
        hobbyArticleLikesRepository.save(hobbyArticleLike);
    }
}
