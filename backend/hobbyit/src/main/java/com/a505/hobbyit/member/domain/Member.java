package com.a505.hobbyit.member.domain;

import com.a505.hobbyit.member.enums.MemberPrivilege;
import com.a505.hobbyit.member.enums.MemberState;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Table(name = "member")
public class Member implements UserDetails {
    @Column(name = "m_id", nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

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

    @CreatedDate
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

//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private MemberPrivilege privilege = MemberPrivilege.GENERAL;
    @Column(nullable = false)
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private List<String> privilege = new ArrayList<>();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberState state = MemberState.ACTIVE;

    public Member() {}

    @Builder
    public Member(Long memberId, String email, String name, String nickname, String password, String intro, LocalDateTime enrollDate, LocalDateTime resignedRequestDate, int ownedHobbyNum, int point, String profileImg, List<String> privilege, MemberState state) {
        this.memberId = memberId;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.intro = intro;
        this.enrollDate = enrollDate;
        this.resignedRequestDate = resignedRequestDate;
        this.ownedHobbyNum = ownedHobbyNum;
        this.point = point;
        this.profileImg = profileImg;
        this.privilege = privilege;
        this.state = state;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.privilege.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

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
