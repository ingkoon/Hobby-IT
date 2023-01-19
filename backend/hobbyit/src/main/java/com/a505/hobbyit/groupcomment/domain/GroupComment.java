package com.a505.hobbyit.groupcomment.domain;


import com.a505.hobbyit.grouparticle.domain.GroupArticle;
import com.a505.hobbyit.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "group_comment")
public class GroupComment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gc_id", nullable = false)
    private Long groupCommentId;

    @ManyToOne
    @JoinColumn(name="group_article_id", nullable = false)
    private GroupArticle groupArticle;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
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
