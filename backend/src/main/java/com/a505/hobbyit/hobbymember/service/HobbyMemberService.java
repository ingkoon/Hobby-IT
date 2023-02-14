package com.a505.hobbyit.hobbymember.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbymember.dto.HobbyMemberUpdateRequest;
import com.a505.hobbyit.hobbymember.dto.OwnHobbyResponse;
import com.querydsl.core.Tuple;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface HobbyMemberService {
    public void updatePrivilege(final Long hobbyId, final Long targetId, HobbyMemberUpdateRequest request);
    public void kickHobbyMember(String memberId, final Long hobbyId, final Long targetId);
    public void resignHobbyMember(String memberId, Long hobbyId);
    public Hobby checkPrivilege(Long hobbyId, String memberId);
    public List<OwnHobbyResponse> getOwnHobby(String memberId);
}
