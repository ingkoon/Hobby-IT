package com.a505.hobbyit.grouparticleimg;

import com.a505.hobbyit.grouparticle.domain.GroupArticle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="group_article_img")
public class GroupArticleImg {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gai_id", nullable = false)
    private Long groupArticleImgId;

    @ManyToOne
    @JoinColumn(name = "group_article_id", nullable = false)
    private GroupArticle groupArticle;

    @Column(nullable = false, length = 80)
    private String img;

}
