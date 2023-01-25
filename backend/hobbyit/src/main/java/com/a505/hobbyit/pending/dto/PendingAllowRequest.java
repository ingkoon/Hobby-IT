package com.a505.hobbyit.pending.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PendingAllowRequest {
    boolean isAllowed;
    Long waitId;
}
