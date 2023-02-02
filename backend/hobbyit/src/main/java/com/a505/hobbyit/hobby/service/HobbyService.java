package com.a505.hobbyit.hobby.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.dto.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HobbyService {
    void save(final String token, final MultipartFile file, final HobbyRequest requestDto);

    HobbyAndMemberResponse findById(final String token, Long hobbyId);

    List<HobbyResponse> findAll();

    List<HobbyResponse> findByKeyword(String keyword, Pageable pageable
    );

    List<HobbyResponse> findPopularHobby();

    List<HobbyResponse> findFreshHobby();

    List<HobbyMemberResponse> findHobbyMembers(Long hobbyId);

    void updateHobby(String token, Long hobbyId, MultipartFile file, HobbyUpdateRequest request);

    void deleteHobby(Long hobbyId, String token);

    Hobby checkPrivilege(Long hobbyId, String token);
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
