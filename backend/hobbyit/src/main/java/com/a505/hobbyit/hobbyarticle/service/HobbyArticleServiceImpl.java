package com.a505.hobbyit.hobbyarticle.service;

import com.a505.hobbyit.common.file.FileUploader;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticleRepository;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleRequest;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleUpdateRequest;
import com.a505.hobbyit.hobbyarticle.exception.NoSuchHobbyArticleException;
import com.a505.hobbyit.hobbyarticleimg.domain.HobbyArticleImg;
import com.a505.hobbyit.hobbyarticleimg.domain.HobbyArticleImgRepository;
import com.a505.hobbyit.hobbymember.domain.HobbyMemberRepository;
import com.a505.hobbyit.hobbymember.exception.NoSuchHobbyMemberException;
import com.a505.hobbyit.jwt.JwtTokenProvider;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HobbyArticleServiceImpl implements HobbyArticleService{
    private final MemberRepository memberRepository;
    private final HobbyRepository hobbyRepository;
    private final HobbyArticleRepository hobbyArticleRepository;
    private final HobbyArticleImgRepository hobbyArticleImgRepository;
    private final HobbyMemberRepository hobbyMemberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    private final FileUploader fileUploader;

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

    @Transactional
    @Override
    public void save(String token, Long hobbyId, HobbyArticleRequest hobbyArticleRequest, List<MultipartFile> files) {
        String memberEmail = jwtTokenProvider.getUser(token);
        Member member = memberRepository.findByEmail(memberEmail).orElseThrow(NoSuchHobbyMemberException::new);
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);

        HobbyArticle hobbyArticle = hobbyArticleRequest.toEntity(member, hobby);

        hobbyArticleRepository.save(hobbyArticle);

        for (MultipartFile file : files) {
            String fileUrl = fileUploader.upload(file, hobbyArticle.getTitle());
            hobbyArticleImgRepository.save(new HobbyArticleImg().toEntity(fileUrl, hobbyArticle));
        }
    }

    @Override
    public HobbyArticleResponse findById(Long articleId) {
        HobbyArticle hobbyArticle = hobbyArticleRepository.getReferenceById(articleId);
        HobbyArticleImg articleImg = hobbyArticle.getHobbyArticleImg().get(0);
        return new HobbyArticleResponse().of(hobbyArticle);
    }

    @Override
    public List<HobbyArticleResponse> findByKeyword(Long hobbyId, String keyword) {
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        List<HobbyArticle> hobbyArticles = hobbyArticleRepository.findByHobbyAndTitleContaining(hobby, keyword);

        List<HobbyArticleResponse> responses = new ArrayList<>();

        for (HobbyArticle hobbyArticle : hobbyArticles) {
//            responses.add(new HobbyArticleResponse().of());
        }
        return responses;
    }

    @Transactional
    @Override
    public void update(Long articleId, HobbyArticleUpdateRequest request) {
        HobbyArticle hobbyArticle = hobbyArticleRepository.getReferenceById(articleId);

        hobbyArticle.updateTitle(request.getTitle());
        hobbyArticle.updateContent(request.getContent());
    }

    @Override
    public void delete(Long articleId) {
        HobbyArticle hobbyArticle = hobbyArticleRepository.findById(articleId).orElseThrow(NoSuchHobbyArticleException::new);
        hobbyArticleRepository.delete(hobbyArticle);
    }
    public Hobby checkPrivilege(Long hobbyId, String token){
        String memberEmail = jwtTokenProvider.getUser(token);
        Member member = memberRepository.findByEmail(memberEmail).orElseThrow(NoSuchElementException::new);
        Hobby hobby = hobbyRepository.findById(hobbyId).orElseThrow(NoSuchHobbyException::new);
        hobbyMemberRepository
                .findByMemberAndHobby(member, hobby)
                .orElseThrow(NoSuchHobbyMemberException::new)
                .checkPrivilege();
        return hobby;
    }
}
