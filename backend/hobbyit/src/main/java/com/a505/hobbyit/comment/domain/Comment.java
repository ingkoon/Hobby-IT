package com.a505.hobbyit.comment.domain;

import com.a505.hobbyit.article.domain.Article;
import com.a505.hobbyit.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "comment")
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id", nullable = false)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 300)
    private String content;

    @Column(nullable = false)
    private LocalDateTime writedDate;

    @Column
    private LocalDateTime modifiedDate;

    @Column
    private LocalDateTime deletedDate;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private int isDeleted;
}
