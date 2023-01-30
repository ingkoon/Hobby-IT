package com.a505.hobbyit.hobbyarticlecomment.domain;


import com.a505.hobbyit.common.BaseEntity;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Table(name = "hobby_article_comment")
public class HobbyArticleComment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hac_id", nullable = false)
    private Long hobbyCommentId;

    @ManyToOne
    @JoinColumn(name="ha_id", nullable = false)
    private HobbyArticle hobbyArticle;

    @ManyToOne
    @JoinColumn(name="m_id", nullable = false)
    private Member member;

    @Column(nullable = false, length = 300)
    private String content;

    public HobbyArticleComment() {}

    @Builder
    public HobbyArticleComment(HobbyArticle hobbyArticle, Member member, String content) {
        this.hobbyArticle = hobbyArticle;
        this.member = member;
        this.content = content;
    }
}
