package com.a505.hobbyit.hobbyarticle.domain;

import com.a505.hobbyit.common.BaseEntity;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbyarticle.enums.HobbyArticleCategory;
import com.a505.hobbyit.member.domain.Member;
import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "hobby_article")
public class HobbyArticle extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hobby_id", nullable = false)
    private Hobby hobby;

    @ManyToOne
    @JoinColumn(name = "mem_id", nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private HobbyArticleCategory category;

    @Column(nullable = false, length = 128)
    private String title;

    @Column(nullable = false, length = 512)
    private String content;

    @Column(nullable = false)
    private int hit = 0;

    @Column(nullable = false)
    private int like = 0;

    @Builder
    public HobbyArticle(Hobby hobby, Member member, HobbyArticleCategory category, int like, String title, String content, int hit) {
        this.hobby = hobby;
        this.member = member;
        this.category = category;
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.like = like;
    }

    //    @Column(nullable = false)
//    private LocalDateTime writedDate;
//
//    @Column
//    private LocalDateTime modifiedDate;
//
//    @Column
//    private LocalDateTime deletedDate;

//    @OneToMany(mappedBy = "groupArticle")
//    private List<GroupArticleImg> groupArticleImgs = new ArrayList<>();
//
//    @OneToMany(mappedBy = "groupArticle")
//    private List<GroupComment> groupComments = new ArrayList<>();

}
