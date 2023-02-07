package com.a505.hobbyit.member.dto.response;

import com.a505.hobbyit.hobby.domain.Hobby;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberHobbyResponse {
    Long id;
    String name;
    String imgUrl;

    public MemberHobbyResponse of(Hobby hobby){
        return MemberHobbyResponse.builder()
                .id(hobby.getId())
                .name(hobby.getName())
                .imgUrl(hobby.getImgUrl()).build();
    }
}
