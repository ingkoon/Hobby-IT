package com.a505.hobbyit.grouparticle;

import com.a505.hobbyit.group.domain.Group;
import com.a505.hobbyit.grouparticleimg.GroupArticleImg;
import com.a505.hobbyit.groupcomment.GroupComment;
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
@Table(name = "group_article")
public class GroupArticle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ga_id", nullable = false)
    private Long groupArticleId;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private int like = 0;

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

    @OneToMany(mappedBy = "groupArticle")
    private List<GroupArticleImg> groupArticleImgs = new ArrayList<>();

    @OneToMany(mappedBy = "groupArticle")
    private List<GroupComment> groupComments = new ArrayList<>();

}
