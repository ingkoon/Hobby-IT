package com.a505.hobbyit.hobbyarticleimg.domain;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name="hobby_article_img")
public class HobbyArticleImg {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hai_id", nullable = false)
    private Long groupArticleImgId;

    @ManyToOne
    @JoinColumn(name = "ha_id", nullable = false)
    private HobbyArticle hobbyArticle;

    @Column(nullable = false, length = 80)
    private String img;

    public HobbyArticleImg() {}

    @Builder
    public HobbyArticleImg(HobbyArticle hobbyArticle, String img) {
        this.hobbyArticle = hobbyArticle;
        this.img = img;
    }
}
