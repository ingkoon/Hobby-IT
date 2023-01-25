package com.a505.hobbyit.hobbymember.domain;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberState;
import com.a505.hobbyit.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name="hobby_member")
public class HobbyMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "hm_id")
    private Long id;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(nullable = false, name = "m_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "h_id")
    private Hobby hobby;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private HobbyMemberState state = HobbyMemberState.ACTIVE;

    @Column(nullable = false)
    private LocalDateTime enrollDate;

    @Column
    private LocalDateTime resignedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "privilege", nullable = false)
    private HobbyMemberPrivilege privilege = HobbyMemberPrivilege.GENERAL;

    public HobbyMember() {}

    @Builder
    public HobbyMember(Member member, Hobby hobby, HobbyMemberState state, LocalDateTime enrollDate, LocalDateTime resignedDate, HobbyMemberPrivilege privilege) {
        this.member = member;
        this.hobby = hobby;
        this.state = state;
        this.enrollDate = enrollDate;
        this.resignedDate = resignedDate;
        this.privilege = privilege;
    }
}
