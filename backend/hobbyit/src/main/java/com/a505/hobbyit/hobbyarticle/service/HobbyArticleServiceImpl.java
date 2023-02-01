package com.a505.hobbyit.hobbyarticle.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticleRepository;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleRequest;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleUpdateRequest;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HobbyArticleServiceImpl implements HobbyArticleService {

    private final MemberRepository memberRepository;
    private final HobbyRepository hobbyRepository;
    private final HobbyArticleRepository hobbyArticleRepository;

    @Override
    public List<HobbyArticleResponse> findAll(Long hobbyId) {
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        List<HobbyArticle> hobbyArticles = hobbyArticleRepository.findByHobby(hobby);

        List<HobbyArticleResponse> responses = new ArrayList<>();

        for (HobbyArticle hobbyArticle : hobbyArticles) {
            responses.add(new HobbyArticleResponse().of(hobbyArticle));
        }
        return responses;
    }

    @Override
    public void save(Long memberId, Long hobbyId, HobbyArticleRequest hobbyArticleRequest) {
        Member member = memberRepository.getReferenceById(memberId);
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        HobbyArticle hobbyArticle = hobbyArticleRequest.toEntity(member, hobby);
        hobbyArticleRepository.save(hobbyArticle);
    }

    @Override
    public HobbyArticleResponse findById(Long articleId) {
        HobbyArticle hobbyArticle = hobbyArticleRepository.getReferenceById(articleId);
        return new HobbyArticleResponse().of(hobbyArticle);
    }

    @Override
    public List<HobbyArticleResponse> findByKeyword(Long hobbyId, String keyword) {
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        List<HobbyArticle> hobbyArticles = hobbyArticleRepository.findByHobbyAndTitleContaining(hobby, keyword);

        List<HobbyArticleResponse> responses = new ArrayList<>();

        for (HobbyArticle hobbyArticle : hobbyArticles) {
            responses.add(new HobbyArticleResponse().of(hobbyArticle));
        }
        return responses;
    }

    @Override
    public void update(Long articleId, HobbyArticleUpdateRequest request) {
        HobbyArticle hobbyArticle = hobbyArticleRepository.getReferenceById(articleId);

        hobbyArticle.updateTitle(request.getTitle());
        hobbyArticle.updateContent(request.getContent());
    }

    @Override
    public void delete(Long articleId) {
        HobbyArticle hobbyArticle = hobbyArticleRepository.getReferenceById(articleId);
        hobbyArticleRepository.delete(hobbyArticle);
    }
}
