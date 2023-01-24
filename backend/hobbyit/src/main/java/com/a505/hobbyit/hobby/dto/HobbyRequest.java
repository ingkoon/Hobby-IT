package com.a505.hobbyit.hobby.dto;


import com.a505.hobbyit.hobby.domain.Hobby;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class HobbyRequest {

    @NotNull(message = "이름이 Null일 수 없습니다.")
    private String name;

    @NotNull(message = "설명이 Null일 수 없습니다.")
    private String intro;

    @NotNull
    private int maxParticipantsNum;

    @NotNull
    private String category;

    @NotNull
    private String img;

    @NotNull
    private int freeRegistration;

    public Hobby toEntity(){
        return Hobby.builder().name(name)
                .intro(intro)
                .maxParticipantsNum(maxParticipantsNum)
                .category(category)
                .img(img)
                .freeRegistration(freeRegistration)
                .build();
    }
}
