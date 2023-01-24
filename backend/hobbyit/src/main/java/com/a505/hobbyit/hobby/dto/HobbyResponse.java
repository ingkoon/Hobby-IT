package com.a505.hobbyit.hobby.dto;

import com.a505.hobbyit.hobby.domain.Hobby;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HobbyResponse {
    private Long id;
    private String name;
    private String img;
    private int participantsNum;
    private int maxParticipantsNum;
    private String intro;
    private String category;
    private int freeRegistration;
    private LocalDateTime createdDate;

    public HobbyResponse of(Hobby hobby){
        return HobbyResponse.builder()
                .id(hobby.getHobbyId())
                .name(hobby.getName())
                .img(hobby.getImg())
                .participantsNum(hobby.getParticipantsNum())
                .maxParticipantsNum(hobby.getMaxParticipantsNum())
                .intro(hobby.getIntro())
                .category(hobby.getCategory())
                .freeRegistration(hobby.getFreeRegistration())
                .createdDate(hobby.getCreatedDate())
                .build();
    }
}
