package com.a505.hobbyit.hobby.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.dto.HobbyMemberResponse;
import com.a505.hobbyit.hobby.dto.HobbyRequest;
import com.a505.hobbyit.hobby.dto.HobbyResponse;
import com.a505.hobbyit.hobby.dto.HobbyUpdateRequest;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.domain.HobbyMemberRepository;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HobbyServiceImpl implements HobbyService{

    private final MemberRepository memberRepository;
    private final HobbyMemberRepository hobbyMemberRepository;
    private final HobbyRepository hobbyRepository;

    @Override
    @Transactional
    public void save(MultipartFile file, HobbyRequest request) {
        Hobby hobby = request.toEntity();
        hobbyRepository.save(hobby);
    }

    @Override
    public HobbyResponse findById(Long hobbyId) {
        Hobby findHobby = hobbyRepository
                .findById(hobbyId)
                .orElseThrow(()-> new NoSuchHobbyException("요청하신 hobby를 찾을 수 없습니다."));
        return new HobbyResponse().of(findHobby);
    }

    @Override
    public List<HobbyResponse> findAll() {
        List<Hobby> hobbies = hobbyRepository.findAll();
        List<HobbyResponse> responses = new ArrayList<>();
        for (Hobby hobby : hobbies) {
            responses.add(new HobbyResponse().of(hobby));
        }
        return responses;
    }

    @Override
    public List<HobbyResponse> findByKeyword(String keyword) {
        List<Hobby> hobbies = hobbyRepository.findByNameLikeOrCategoryLike(keyword, keyword);
        List<HobbyResponse> responses = new ArrayList<>();
        for (Hobby hobby : hobbies) {
            responses.add(new HobbyResponse().of(hobby));
        }
        return responses;
    }

    @Override
    public List<HobbyResponse> findPopularHobby() {
        List<Hobby> hobbies = hobbyRepository.findPopularHobby();
        List<HobbyResponse> responses = new ArrayList<>();
        for (Hobby hobby : hobbies) {
            responses.add(new HobbyResponse().of(hobby));
        }
        return responses;
    }

    @Override
    public List<HobbyResponse> findFreshHobby() {
        List<Hobby> hobbies = hobbyRepository.findFreshHobby();
        List<HobbyResponse> responses = new ArrayList<>();
        for (Hobby hobby : hobbies) {
            responses.add(new HobbyResponse().of(hobby));
        }
        return responses;
    }

    @Override
    public List<HobbyMemberResponse> findHobbyMembers(Long hobbyId) {
        Hobby hobby = hobbyRepository.findById(hobbyId).orElseThrow(NoSuchHobbyException::new);
        List<HobbyMemberResponse> responses = new ArrayList<>();
        List<HobbyMember> members = hobby.getHobbyMembers();

        for (HobbyMember member : members) {
            responses.add(new HobbyMemberResponse().toEntity(member));
        }

        return responses;
    }

    public void updateHobby(HobbyUpdateRequest request){

    }
    @Override
    public void deleteHobby(Long hobbyId, Long memberId) {
        Member member = memberRepository.getById(memberId);
        Hobby hobby = hobbyRepository.findById(hobbyId).orElseThrow(NoSuchHobbyException::new);
        hobbyMemberRepository
                .getByMemberAndHobby(member, hobby)
                .checkPrivilege();

        hobbyRepository.delete(hobby);
    }
}
