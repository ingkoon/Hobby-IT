package com.a505.hobbyit.hobbymember.dto;

import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import lombok.Getter;

@Getter
public class HobbyMemberUpdateRequest {
    HobbyMemberPrivilege privilege;
}
