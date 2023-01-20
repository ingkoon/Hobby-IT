package com.a505.hobbyit.hobby.domain;


import com.a505.hobbyit.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "hobby")
public class Hobby {

    @Column(name = "h_id", nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hobbyId;

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
    private LocalDateTime deletedDate;

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
    //    @OneToMany(mappedBy = "group")
//    private List<Pending> pendings = new ArrayList<>();
//
//    @OneToMany(mappedBy = "group")
//    private List<GroupUser> groupUsers = new ArrayList<>();
//
//    @OneToMany(mappedBy = "group")
//    private List<GroupArticle> groupArticles = new ArrayList<>();
//
//    @OneToMany(mappedBy = "group")
//    private List<Postit> postits = new ArrayList<>();
}
