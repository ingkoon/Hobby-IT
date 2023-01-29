package com.a505.hobbyit.member.domain;

import com.a505.hobbyit.member.enums.MemberPrivilege;
import com.a505.hobbyit.member.enums.MemberState;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "member")
public class Member {
    @Column(nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    private String email;

    @Column(nullable = false, length = 16)
    private String name;

    @Column(nullable = false, length = 16)
    private String nickname;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(length = 128)
    private String intro;

    @Column(name =  "reg_dt", nullable = false)
    private LocalDateTime enrollDate;

    @Column(name = "resd_req_dt")
    private LocalDateTime resignedRequestDate;

    @Column(nullable = false)
    private int ownedHobbyCnt;

    @Column(nullable = false)
    private int point;

    @Column(nullable = false)
    private String imgUrl;

//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private MemberPrivilege privilege = MemberPrivilege.GENERAL;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberState state = MemberState.ACTIVE;

    @Builder
    public Member(String email, String name, String nickname, String intro, LocalDateTime enrollDate, LocalDateTime resignedRequestDate, int ownedHobbyCnt, int point, String imgUrl, MemberState state) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.intro = intro;
        this.enrollDate = enrollDate;
        this.resignedRequestDate = resignedRequestDate;
        this.ownedHobbyCnt = ownedHobbyCnt;
        this.point = point;
        this.imgUrl = imgUrl;
//        this.privilege = privilege;
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
