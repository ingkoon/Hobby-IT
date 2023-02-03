package com.a505.hobbyit.member.domain;

import com.a505.hobbyit.common.BaseEntity;
import com.a505.hobbyit.member.enums.MemberState;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Table(name = "member")
public class Member extends BaseEntity implements UserDetails {
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(nullable = false)
    private int ownedHobbyCnt;

    @Column(nullable = false)
    private int point;

    @Column
    private String imgUrl;

    @Column(nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    private MemberState state;

    @Column
    private LocalDateTime resdReqDt;

    @Column(nullable = false)
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private Set<String> privilege;

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

    public Member() {
    }

    @Builder
    public Member(Long id, String email, String name, String nickname, String password, String intro, int ownedHobbyCnt, int point, String imgUrl, LocalDateTime resdReqDt, Set<String> privilege) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.intro = intro;
        this.ownedHobbyCnt = ownedHobbyCnt;
        this.point = point;
        this.imgUrl = imgUrl;
        this.state = MemberState.ACTIVE;
        this.resdReqDt = resdReqDt;
        this.privilege = privilege;
    }


    public void resetPassword(String password) {
        this.password = password;
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
