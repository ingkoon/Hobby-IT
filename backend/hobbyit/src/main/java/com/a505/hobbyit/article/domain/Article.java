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
    @Column(name = "a_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "m_id")
    private Member member;

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

}
