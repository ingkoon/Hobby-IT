package com.a505.hobbyit.article.domain;

import com.a505.hobbyit.member.domain.Member;
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
@Table(name = "article")
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false, length = 16)
    private String header;

    @Column(nullable = false, length = 128)
    private String title;

    @Column(nullable = false, length = 512)
    private String content;

    @Column(nullable = false)
    private int hit = 0;

    @Column(name="reg_dt", nullable = false)
    private LocalDateTime writtenDate;

    @Column(name= "chg_dt")
    private LocalDateTime modifiedDate;

//    @OneToMany(mappedBy = "article")
//    private List<Comment> comments = new ArrayList<>();
}
