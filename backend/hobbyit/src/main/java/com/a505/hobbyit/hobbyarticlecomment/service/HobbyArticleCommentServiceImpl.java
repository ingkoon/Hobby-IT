package com.a505.hobbyit.hobbyarticlecomment.service;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticleRepository;
import com.a505.hobbyit.hobbyarticle.exception.NoSuchHobbyArticleException;
import com.a505.hobbyit.hobbyarticlecomment.domain.HobbyArticleComment;
import com.a505.hobbyit.hobbyarticlecomment.domain.HobbyArticleCommentRepository;
import com.a505.hobbyit.hobbyarticlecomment.dto.CommentRequest;
import com.a505.hobbyit.hobbyarticlecomment.dto.CommentResponse;
import com.a505.hobbyit.hobbyarticlecomment.exception.NoSuchCommentException;
import com.a505.hobbyit.jwt.JwtTokenProvider;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class HobbyArticleCommentServiceImpl implements HobbyArticleCommentService{

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;
    private final HobbyArticleCommentRepository hobbyArticleCommentRepository;
    private final HobbyArticleRepository hobbyArticleRepository;

    @Override
    public void save(String token, Long articleId, CommentRequest request) {
        Member member = memberRepository.findByEmail(jwtTokenProvider.getUser(token))
                .orElseThrow(NoSuchElementException::new);
        HobbyArticle hobbyArticle = hobbyArticleRepository
                .findById(articleId)
                .orElseThrow(NoSuchHobbyArticleException::new);
        HobbyArticleComment hobbyArticleComment = request.toEntity(member, hobbyArticle);

        hobbyArticleCommentRepository.save(hobbyArticleComment);
    }

    @Override
    public List<CommentResponse> findAll(Long articleId) {
        HobbyArticle hobbyArticle = hobbyArticleRepository
                .findById(articleId)
                .orElseThrow(NoSuchHobbyArticleException::new);

        List<HobbyArticleComment> comments = hobbyArticle.getHobbyArticleComments();
        List<CommentResponse> response = new ArrayList<>();
        for (HobbyArticleComment comment : comments) {
            response.add(new CommentResponse().of(comment));
        }
        return response;
    }

    @Override
    public void updateComment(String token, Long commentId, CommentRequest request) {
        HobbyArticleComment comment = hobbyArticleCommentRepository
                .findById(commentId)
                .orElseThrow(NoSuchCommentException::new);
        comment.updateContent(request.getContent());
    }

    @Override
    public void deleteComment(Long commentId) {
        hobbyArticleCommentRepository.deleteById(commentId);
    }
}
