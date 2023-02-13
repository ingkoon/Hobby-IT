package com.a505.hobbyit.hobbymember.dto;

import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnHobbyResponse {
    private Long id;
    private String name;

    public OwnHobbyResponse of(HobbyMember hobbyMember){
        return OwnHobbyResponse.builder()
                .id(hobbyMember.getHobby().getId())
                .name(hobbyMember.getHobby().getName())
                .build();
    }
}
