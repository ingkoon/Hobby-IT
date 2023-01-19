package com.a505.hobbyit.group.domain;


import com.a505.hobbyit.application.Application;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "group")
public class Group {

    @Column(name = "g_id", nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;


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

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime deletedDate;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private int freeRegistration;

    @OneToMany(mappedBy = "group")
    private List<Application> applications = new ArrayList<>();
}
