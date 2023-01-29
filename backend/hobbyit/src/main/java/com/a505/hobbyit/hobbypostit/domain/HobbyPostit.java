package com.a505.hobbyit.hobbypostit.domain;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "hobby_postit")
public class HobbyPostit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hobby_id", nullable = false)
    private Hobby hobby;

    @ManyToOne
    @JoinColumn(name = "mem_id", nullable = false)
    private Member member;

    @Column(nullable = false, length = 255)
    private String canvas;

    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime writedDate;

}
