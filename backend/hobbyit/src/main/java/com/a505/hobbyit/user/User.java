package com.a505.hobbyit.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Column(name = "u_id", nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;
    @Column
    private String intro;

    @Column(nullable = false)
    private LocalDateTime enrollDate;

    @Column
    private LocalDateTime resignedRequestDate;

    @Column(nullable = false)
    private int ownedGroupNum;

    @Column(nullable = false)
    private int point;

    @Column(nullable = false)
    private String profileImg;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserPrivilege privilege = UserPrivilege.GENERAL;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserState state = UserState.ACTIVE;
}
