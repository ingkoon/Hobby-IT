package com.a505.hobbyit.article.domain;

import com.a505.hobbyit.comment.domain.Comment;
import com.a505.hobbyit.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "article")
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 15)
    private String header;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 300)
    private String content;

    @Column(nullable = false)
    private int hit = 0;

    @Column(nullable = false)
    private LocalDateTime writedDate;

    @Column
    private LocalDateTime modifiedDate;

    @Column
    private LocalDateTime deletedDate;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private int isDeleted;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments = new ArrayList<>();
}
