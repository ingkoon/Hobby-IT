package com.a505.hobbyit.hobby.domain;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbypostit.domain.HobbyPostit;
import com.a505.hobbyit.pending.domain.Pending;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "hobby")
public class Hobby {

    @Column(name = "h_id", nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(length = 80)
    private String img;

    @Column(nullable = false)
    private int participantsNum;

    @Column(nullable = false)
    private int maxParticipantsNum;

    @Column(nullable = false, length = 150)
    private String intro;

    @Column(nullable = false, length = 20)
    private String category;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private int freeRegistration;

    @Column(nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column
    private LocalDateTime deletedDate = null;

    public Hobby() {}

    @Builder
    public Hobby(String name, String img, int participantsNum, int maxParticipantsNum, String intro, String category, int freeRegistration) {
        this.name = name;
        this.img = img;
        this.participantsNum = participantsNum;
        this.maxParticipantsNum = maxParticipantsNum;
        this.intro = intro;
        this.category = category;
        this.freeRegistration = freeRegistration;
    }

    @OneToMany(mappedBy = "hobby")
    private List<Pending> pendings = new ArrayList<>();

    @OneToMany(mappedBy = "hobby")
    private List<HobbyMember> groupUsers = new ArrayList<>();

    @OneToMany(mappedBy = "hobby")
    private List<HobbyArticle> groupArticles = new ArrayList<>();

    @OneToMany(mappedBy = "hobby")
    private List<HobbyPostit> postits = new ArrayList<>();

    public void updateName(String name){
        this.name = name;
    }

    public void updateIntro(String intro){
        this.intro = intro;
    }

    public void updateMaxParticipantsNum(int maxParticipantsNum){
        this.maxParticipantsNum = maxParticipantsNum;
    }

    public void updateImg(String img){
        this.img = img;
    }
}
