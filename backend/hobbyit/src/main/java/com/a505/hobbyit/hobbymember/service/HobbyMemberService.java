package com.a505.hobbyit.hobbymember.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbymember.dto.HobbyMemberUpdateRequest;

public interface HobbyMemberService {
    public void updatePrivilege(final String token, final Long hobbyId, final Long targetId, HobbyMemberUpdateRequest request);
    public void kickHobbyMember(final String token, final Long hobbyId, final Long targetId);
    public void resignHobbyMember(String token, Long hobbyId);
    public Hobby checkPrivilege(Long hobbyId, String token);
}
