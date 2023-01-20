package com.a505.hobbyit.hobbyarticle.domain;

import com.a505.hobbyit.common.BaseEntity;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.member.domain.Member;
import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Table(name = "hobby_article")
public class HobbyArticle extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ha_id", nullable = false)
    private Long groupArticleId;

    @ManyToOne
    @JoinColumn(name = "h_id", nullable = false)
    private Hobby hobby;

    @ManyToOne
    @JoinColumn(name = "m_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private int like = 0;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 300)
    private String content;

    @Column(nullable = false)
    private int hit = 0;

    public HobbyArticle() {}

    @Builder
    public HobbyArticle(Hobby hobby, Member member, int like, String title, String content, int hit) {
        this.hobby = hobby;
        this.member = member;
        this.like = like;
        this.title = title;
        this.content = content;
        this.hit = hit;
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
