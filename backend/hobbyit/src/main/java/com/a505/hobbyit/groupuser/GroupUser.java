package com.a505.hobbyit.groupuser;

import com.a505.hobbyit.group.domain.Group;
import com.a505.hobbyit.groupuser.enums.GroupUserPrivilege;
import com.a505.hobbyit.groupuser.enums.GroupUserState;
import com.a505.hobbyit.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name="group_user")
public class GroupUser {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "gu_id")
    private Long groupUserId;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false, name = "group_id")
    private Group group;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private GroupUserState state = GroupUserState.ACTIVE;

    @Column(nullable = false)
    private LocalDateTime enrollDate;

    @Column
    private LocalDateTime resignedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "privilege", nullable = false)
    private GroupUserPrivilege privilege = GroupUserPrivilege.GENERAL;
}
