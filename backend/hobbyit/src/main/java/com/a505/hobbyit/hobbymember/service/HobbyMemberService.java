package com.a505.hobbyit.hobbymember.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbymember.dto.HobbyMemberUpdateRequest;

public interface HobbyMemberService {
    void updatePrivilege(final String token, final Long hobbyId, final Long targetId, HobbyMemberUpdateRequest request);

    void kickHobbyMember(final String token, final Long hobbyId, final Long targetId);

    void resignHobbyMember(String token, Long hobbyId);

    Hobby checkPrivilege(Long hobbyId, String token);
}
