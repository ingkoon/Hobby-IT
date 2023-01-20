package com.a505.hobbyit.member.domain;

import com.a505.hobbyit.common.BaseEntity;
import com.a505.hobbyit.member.enums.MemberPrivilege;
import com.a505.hobbyit.member.enums.MemberState;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
//@AllArgsConstructor
@Table(name = "member")
public class Member {
    @Column(name = "m_id", nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column
    private String intro;

    @Column(nullable = false)
    private LocalDateTime enrollDate;

    @Column
    private LocalDateTime resignedRequestDate;

    @Column(nullable = false)
    private int ownedHobbyNum;

    @Column(nullable = false)
    private int point;

    @Column(nullable = false)
    private String profileImg;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberPrivilege privilege = MemberPrivilege.GENERAL;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberState state = MemberState.ACTIVE;

    @Builder
    public Member(String email, String name, String nickname, String intro, LocalDateTime enrollDate, LocalDateTime resignedRequestDate, int ownedHobbyNum, int point, String profileImg, MemberPrivilege privilege, MemberState state) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.intro = intro;
        this.enrollDate = enrollDate;
        this.resignedRequestDate = resignedRequestDate;
        this.ownedHobbyNum = ownedHobbyNum;
        this.point = point;
        this.profileImg = profileImg;
        this.privilege = privilege;
        this.state = state;
    }

    public Member() {}

//    @OneToMany(mappedBy = "member")
//    private List<Pending> pendings = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<GroupUser> groupUsers = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<GroupArticle> groupArticles = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<GroupComment> groupComments = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<Article> articles = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<Comment> comments = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<Postit> postits = new ArrayList<>();
}
