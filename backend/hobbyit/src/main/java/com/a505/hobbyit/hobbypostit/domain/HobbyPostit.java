package com.a505.hobbyit.hobbypostit.domain;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "hobby_postit")
public class HobbyPostit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hp_id", nullable = false)
    private Long hobbyPostitId;

    @ManyToOne
    @JoinColumn(name = "h_id", nullable = false)
    private Hobby hobby;

    @ManyToOne
    @JoinColumn(name = "m_id", nullable = false)
    private Member member;

    @Column(nullable = false, length = 30)
    private String canvas;

    @Column(nullable = false)
    private LocalDateTime writedDate;
}
