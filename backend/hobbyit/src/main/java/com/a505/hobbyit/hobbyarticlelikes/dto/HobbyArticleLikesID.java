package com.a505.hobbyit.hobbyarticlelikes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HobbyArticleLikesID implements Serializable {
    private Long hobby_mem_id;
    private Long mem_id;
}
