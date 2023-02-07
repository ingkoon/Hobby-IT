package com.a505.hobbyit.member.dto.response;

import com.a505.hobbyit.hobby.domain.Hobby;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MemberPendingResponse {
    Long id;
    String name;
    String imgUrl;
    public MemberPendingResponse of(Hobby hobby){
        return MemberPendingResponse.builder()
                .id(hobby.getId())
                .name(hobby.getName())
                .imgUrl(hobby.getImgUrl())
                .build();
    }
}
