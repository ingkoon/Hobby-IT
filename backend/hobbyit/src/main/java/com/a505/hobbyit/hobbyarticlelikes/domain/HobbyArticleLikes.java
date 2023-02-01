package com.a505.hobbyit.hobbyarticlelikes.domain;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticlelikes.dto.HobbyArticleLikesID;
import com.a505.hobbyit.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(HobbyArticleLikesID.class)
@Table(name="hobby_article_likes")
public class HobbyArticleLikes {

    @Id
    @ManyToOne
    @JoinColumn(name = "hobby_art_id", nullable = false)
    private HobbyArticle hobbyArticle;

    @Id
    @ManyToOne
    @JoinColumn(name = "mem_id", nullable = false)
    private Member member;

}
