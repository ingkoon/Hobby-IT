package com.a505.hobbyit.hobby.service;

import com.a505.hobbyit.hobby.dto.HobbyMemberResponse;
import com.a505.hobbyit.hobby.dto.HobbyRequest;
import com.a505.hobbyit.hobby.dto.HobbyResponse;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.member.domain.Member;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HobbyService {
    public void save(final MultipartFile file, final HobbyRequest request);
    public HobbyResponse findById(Long hobbyId);
    public List<HobbyResponse> findAll();
    public List<HobbyResponse> findByKeyword(String keyword);
    public List<HobbyResponse> findPopularHobby();
    public List<HobbyResponse> findFreshHobby();
    public List<HobbyMemberResponse> findHobbyMembers(Long hobbyId);
    public void deleteHobby(Long hobbyId, Long memberId);
}

/*
모임 생성
모임 정보 확인
모임 리스트 확인
모임 검색 -> 키워드에 따라서 분리
인기있는 모임 리스트
새로 생긴 모임 리스트
모임 회원 명단 확인
모임 삭제
 */
