package com.a505.hobbyit.hobbyarticlecomment.domain;


import com.a505.hobbyit.common.BaseEntity;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "hobby_article_comment")
public class HobbyArticleComment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="hobby_art_id", nullable = false)
    private HobbyArticle hobbyArticle;

    @ManyToOne
    @JoinColumn(name="mem_id", nullable = false)
    private Member member;

    @Column(nullable = false, length = 255)
    private String content;

    @Builder
    public HobbyArticleComment(HobbyArticle hobbyArticle, Member member, String content) {
        this.hobbyArticle = hobbyArticle;
        this.member = member;
        this.content = content;
    }
}
