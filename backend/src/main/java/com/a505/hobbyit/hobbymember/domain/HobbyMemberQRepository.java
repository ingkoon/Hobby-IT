package com.a505.hobbyit.hobbymember.domain;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbymember.dto.OwnHobbyResponse;
import com.a505.hobbyit.member.domain.Member;
import com.querydsl.core.Tuple;

import java.util.List;

public interface HobbyMemberQRepository {
    public List<OwnHobbyResponse> getOwnHobbyList(Member member);
}
