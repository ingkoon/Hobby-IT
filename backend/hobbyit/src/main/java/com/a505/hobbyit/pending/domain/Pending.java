package com.a505.hobbyit.pending.domain;

import com.a505.hobbyit.common.BaseEntity;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.pending.enums.PendingAllow;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pending extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "hobby_id")
    private Hobby hobby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "member_id")
    private Member member;

    @Column(nullable = false, length = 128)
    private String msg;

//    @Column(name = "reg_dt", nullable = false)
//    private LocalDateTime apply_date;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", length = 16)
    private PendingAllow pendingAllow;

    public void updatePendingAllow(PendingAllow pendingALlow) {
        this.pendingAllow = pendingALlow;
    }
}
