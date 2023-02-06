package com.a505.hobbyit.hobbyarticle.service;

import com.a505.hobbyit.common.file.FileUploader;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticleRepository;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleDetailResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleRequest;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleUpdateRequest;
import com.a505.hobbyit.hobbyarticle.exception.NoSuchHobbyArticleException;
import com.a505.hobbyit.hobbyarticleimg.domain.HobbyArticleImg;
import com.a505.hobbyit.hobbyarticleimg.domain.HobbyArticleImgRepository;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.domain.HobbyMemberRepository;
import com.a505.hobbyit.hobbymember.exception.NoSuchHobbyMemberException;
import com.a505.hobbyit.jwt.JwtTokenProvider;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Transactional(readOnly = true)
@Service
@Slf4j
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
    public Slice<HobbyArticleResponse> findAll(Long storedId, String token, Long hobbyId, Pageable pageable) {
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        return hobbyArticleRepository.findHobbyArticle(storedId, hobby, pageable);
    }

    @Transactional
    @Override
    public void save(String token, Long hobbyId, HobbyArticleRequest hobbyArticleRequest, List<MultipartFile> files) {
        String memberEmail = jwtTokenProvider.getUser(token);
        Member member = memberRepository.findByEmail(memberEmail).orElseThrow(NoSuchHobbyMemberException::new);
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);

        HobbyArticle hobbyArticle = hobbyArticleRequest.toEntity(member, hobby);

        log.info(member.getId() + " =========== " + hobby.getId());
        log.info(hobbyArticle.toString());
        hobbyArticleRepository.save(hobbyArticle);

        for (MultipartFile file : files) {
            String fileUrl = fileUploader.upload(file, hobbyArticle.getTitle());
            hobbyArticleImgRepository.save(new HobbyArticleImg().toEntity(fileUrl, hobbyArticle));
        }
    }

    @Override
    public HobbyArticleDetailResponse findById(final String token , final Long hobbyId, final Long articleId) {
        HobbyArticle hobbyArticle = hobbyArticleRepository.getReferenceById(articleId);
        hobbyArticle.updateHit();
        return new HobbyArticleDetailResponse().of(hobbyArticle);
    }

    @Override
    public Slice<HobbyArticleResponse> findByKeyword(Long storedId, String token, String keyword, final Long hobbyId, Pageable pageable) {
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        return hobbyArticleRepository.searchHobbyArticle(storedId,  keyword, hobby, pageable);
    }

    @Override
    public Page<HobbyArticleResponse> findAllNotice(final Long hobbyId, Pageable pageable) {
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        return hobbyArticleRepository.findHobbyNotice(hobby, pageable);
    }

    @Override
    public Page<HobbyArticleResponse> findNoticeByKeyWord(final Long hobbyId, String keyword, Pageable pageable) {
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        return hobbyArticleRepository.searchHobbyNotice(hobby, keyword, pageable);
    }

    @Transactional
    @Override
    public void update(final Long articleId, HobbyArticleUpdateRequest request) {
        HobbyArticle hobbyArticle = hobbyArticleRepository.getReferenceById(articleId);
        hobbyArticle.updateTitle(request.getTitle());
        hobbyArticle.updateContent(request.getContent());
    }

    @Transactional
    @Override
    public void delete(Long articleId) {
        HobbyArticle hobbyArticle = hobbyArticleRepository.findById(articleId).orElseThrow(NoSuchHobbyArticleException::new);
        hobbyArticleRepository.delete(hobbyArticle);
    }
}
