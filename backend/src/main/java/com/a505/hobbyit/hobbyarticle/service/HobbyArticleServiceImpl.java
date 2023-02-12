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
import com.a505.hobbyit.hobbymember.exception.UnAuthorizedHobbyMemberException;
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

import java.util.List;

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
    private final FileUploader fileUploader;

    /*
    모든 소모임 내 게시글을 가져온다.
    회원Id, 현재 게시글 번호, 소모임Id, size를 매개변수로 받는다.
     */
    @Override
    public Slice<HobbyArticleResponse> findAll(String memberId, Long storedId, Long hobbyId, Pageable pageable) {
        Member member = memberRepository.findById(Long.parseLong(memberId))
                .orElseThrow(NoSuchHobbyMemberException::new);
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        checkMember(member, hobby);
        return hobbyArticleRepository.findHobbyArticle(storedId, hobby, pageable);
    }

    @Transactional
    @Override
    public void save(String memberId, Long hobbyId, HobbyArticleRequest hobbyArticleRequest, List<MultipartFile> files) {
        Member member = memberRepository.findById(Long.parseLong(memberId)).orElseThrow(NoSuchHobbyMemberException::new);
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        checkMember(member, hobby);
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
    public HobbyArticleDetailResponse findById(String memberId, final Long hobbyId, final Long articleId) {
        Member member = memberRepository.findById(Long.parseLong(memberId)).orElseThrow(NoSuchHobbyMemberException::new);
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        checkMember(member, hobby);
        HobbyArticle hobbyArticle = hobbyArticleRepository.getReferenceById(articleId);
        hobbyArticle.updateHit();

        return new HobbyArticleDetailResponse().of(hobbyArticle);
    }

    @Override
    public Slice<HobbyArticleResponse> findByKeyword(String memberId, Long storedId, String keyword, final Long hobbyId, Pageable pageable) {
        Member member = memberRepository.findById(Long.parseLong(memberId)).orElseThrow(NoSuchHobbyMemberException::new);
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        checkMember(member, hobby);
        return hobbyArticleRepository.searchHobbyArticle(storedId,  keyword, hobby, pageable);
    }

    @Override
    public Page<HobbyArticleResponse> findAllNotice(String memberId, final Long hobbyId, Pageable pageable) {
        Member member = memberRepository.findById(Long.parseLong(memberId)).orElseThrow(NoSuchHobbyMemberException::new);
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        checkMember(member, hobby);
        return hobbyArticleRepository.findHobbyNotice(hobby, pageable);
    }

    @Override
    public Page<HobbyArticleResponse> findNoticeByKeyWord(String memberId, final Long hobbyId, String keyword, Pageable pageable) {
        Member member = memberRepository.findById(Long.parseLong(memberId)).orElseThrow(NoSuchHobbyMemberException::new);
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        checkMember(member, hobby);
        return hobbyArticleRepository.searchHobbyNotice(hobby, keyword, pageable);
    }

    @Transactional
    @Override
    public void update(String memberId, final Long articleId, HobbyArticleUpdateRequest request) {
        HobbyArticle hobbyArticle = hobbyArticleRepository
                .findById(articleId)
                .orElseThrow(NoSuchHobbyArticleException::new);
        if(hobbyArticle.getMember().getId()!= Long.parseLong(memberId))
            throw new UnAuthorizedHobbyMemberException();
        hobbyArticle.updateTitle(request.getTitle());
        hobbyArticle.updateContent(request.getContent());
    }

    @Transactional
    @Override
    public void delete(String memberId,Long hobbyId, Long articleId) {
        Member member = memberRepository.findById(Long.parseLong(memberId)).orElseThrow(NoSuchHobbyMemberException::new);
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        checkMember(member, hobby);
        HobbyArticle hobbyArticle = hobbyArticleRepository
                .findById(articleId)
                .orElseThrow(NoSuchHobbyArticleException::new);
        hobbyArticleRepository.delete(hobbyArticle);
    }

    public void checkMember(Member member, Hobby hobby){ // 가입된 회원인지 혹은 탈퇴된회원인지 확인을 위한 method
        HobbyMember hobbyMember = hobbyMemberRepository
                .findByMemberAndHobby(member, hobby)
                .orElseThrow(()->new NoSuchHobbyMemberException()); // 없는 경우 hobby member를 찾을 수 없다고 반환
        hobbyMember.checkMember(); // hobbymember의 현재 상태가 ACTIVE인지 확인
    }
}
