package com.a505.hobbyit.pending.domain;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pending {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id", nullable = false)
    private Long pendingId;

    @ManyToOne
    @JoinColumn(nullable = false, name = "h_id")
    private Hobby hobby;

    @ManyToOne
    @JoinColumn(nullable = false, name = "m_id")
    private Member member;

    @Column(nullable = false, length = 200)
    private String message;

    @Column(nullable = false)
    private LocalDateTime apply_date;
}
