package com.a505.hobbyit.hobby.dto;

import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HobbyMemberResponse {
    private Long id;
    private String nickName;
    private HobbyMemberPrivilege privilege;

    public HobbyMemberResponse toEntity(HobbyMember hobbyMember){
        return HobbyMemberResponse
                .builder()
                .id(hobbyMember.getId())
                .nickName(hobbyMember.getMember().getNickname())
                .privilege(hobbyMember.getPrivilege())
                .build();
    }

}
