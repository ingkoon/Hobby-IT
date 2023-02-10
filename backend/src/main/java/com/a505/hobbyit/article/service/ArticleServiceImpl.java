package com.a505.hobbyit.article.service;

import com.a505.hobbyit.article.domain.Article;
import com.a505.hobbyit.article.domain.ArticleRepository;
import com.a505.hobbyit.article.dto.ArticleRequest;
import com.a505.hobbyit.article.dto.ArticleResponse;
import com.a505.hobbyit.article.exception.NoSuchArticleException;
import com.a505.hobbyit.article.exception.UnAuthorizedArticleException;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.domain.HobbyMemberRepository;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import com.a505.hobbyit.hobbymember.exception.NoSuchHobbyMemberException;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import com.a505.hobbyit.member.exception.NoSuchMemberException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    private final HobbyRepository hobbyRepository;
    private final HobbyMemberRepository hobbyMemberRepository;
    private static final String COOKIE_NAME_FORM = "ViewedArticleID";

    @Transactional
    @Override
    public void save(Long memberId, Long hobbyId, ArticleRequest articleRequest) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NoSuchMemberException("회원 정보 오류"));
        Hobby hobby = hobbyRepository.findById(hobbyId)
                .orElseThrow(() -> new NoSuchHobbyException("소모임 정보 오류"));
        HobbyMember hobbyMember = hobbyMemberRepository.findByMemberAndHobby(member, hobby)
                .orElseThrow(() -> new NoSuchHobbyMemberException("소모임 가입 정보 오류"));
        if (!hobbyMember.getPrivilege().equals(HobbyMemberPrivilege.OWNER))
            throw new UnAuthorizedArticleException("권한 없음");
        Article article = articleRequest.toEntity(member);
        articleRepository.save(article);
    }

    @Override
    public Page<ArticleResponse> findArticlesByPageRequest(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return articleRepository.findAll(pageable).map(article -> new ArticleResponse().of(article));
    }

    @Transactional
    @Override
    public ArticleResponse findById(Long articleId, HttpServletRequest request, HttpServletResponse response) {
        Article article = articleRepository
                .findById(articleId)
                .orElseThrow(() -> new NoSuchArticleException("게시글이 존재하지 않습니다."));
        Cookie[] cookies = request.getCookies();
        if (cookies == null ||
                Arrays.stream(cookies)
                        .filter(cookie -> cookie.getName().equals(COOKIE_NAME_FORM + articleId))
                        .findAny().isEmpty()) {
            Cookie cookie = new Cookie(COOKIE_NAME_FORM + articleId, String.valueOf(articleId));
            cookie.setMaxAge(
                    (int) LocalDateTime.now().until(
                            LocalDateTime.now().plusHours(1L).truncatedTo(ChronoUnit.HOURS),
                            ChronoUnit.SECONDS
                    )
            );
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            article.updateHit();
        }
        return new ArticleResponse().of(article);
    }

    @Transactional
    @Override
    public void update(Long memberId, Long articleId, ArticleRequest articleRequest) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NoSuchMemberException("회원 정보 오류"));
        Article article = articleRepository
                .findById(articleId)
                .orElseThrow(() -> new NoSuchArticleException("게시글이 존재하지 않습니다."));
        if (!Objects.equals(article.getMember().getId(), member.getId()))
            throw new UnAuthorizedArticleException("권한 없음");
        article.updateArticle(articleRequest);
    }

    @Transactional
    @Override
    public void deleteById(Long memberId, Long articleId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NoSuchMemberException("회원 정보 오류"));
        Article article = articleRepository
                .findById(articleId)
                .orElseThrow(() -> new NoSuchArticleException("게시글이 존재하지 않습니다."));
        if (!Objects.equals(article.getMember().getId(), member.getId()))
            throw new UnAuthorizedArticleException("권한 없음");
        articleRepository.deleteById(articleId);
    }
}
