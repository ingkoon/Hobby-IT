package com.a505.hobbyit.hobbyarticle.dto;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticleimg.domain.HobbyArticleImg;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HobbyArticleResponse {
    String title;

    String content;

    String author;

    String authorImage;

    LocalDateTime createdAt;

    List<HobbyArticleImg> images;

    int likes;

    public HobbyArticleResponse of(HobbyArticle hobbyArticle) {
        return HobbyArticleResponse.builder()
                .title(hobbyArticle.getTitle())
                .content(hobbyArticle.getContent())
                .author(hobbyArticle.getMember().getName())
                .authorImage(hobbyArticle.getMember().getImgUrl())
                .createdAt(hobbyArticle.getRegDt())
                .images(hobbyArticle.getHobbyArticleImg())
                .build();
    }
}
