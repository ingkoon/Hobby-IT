package com.a505.hobbyit.comment.domain;

import com.a505.hobbyit.article.domain.Article;
import com.a505.hobbyit.common.BaseEntity;
import com.a505.hobbyit.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id", nullable = false)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "a_id", nullable = false)
    private Article article;

    @ManyToOne
    @JoinColumn(name = "m_id", nullable = false)
    private Member member;

    @Column(nullable = false, length = 300)
    private String content;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private int isDeleted;

    public Comment() {}

    @Builder
    public Comment(Article article, Member member, String content, int isDeleted) {
        this.article = article;
        this.member = member;
        this.content = content;
        this.isDeleted = isDeleted;
    }
}
