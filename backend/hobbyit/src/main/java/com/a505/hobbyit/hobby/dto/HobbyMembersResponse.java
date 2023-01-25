package com.a505.hobbyit.hobby.dto;

import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HobbyMembersResponse {
    private Long id;
    private String nickName;
    private HobbyMemberPrivilege privilege;


}
