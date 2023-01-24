package com.a505.hobbyit.hobby.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.dto.HobbyRequest;
import com.a505.hobbyit.hobby.dto.HobbyResponse;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HobbyServiceImpl implements HobbyService{

    private final HobbyRepository hobbyRepository;

    @Override
    @Transactional
    public HobbyResponse save(HobbyRequest request) {
        Hobby hobby = request.toEntity();
        hobbyRepository.save(hobby);
        return new HobbyResponse().of(hobby);
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
    public List<HobbyResponse> findByKeyword(String category, String keyword) {
        List<Hobby> hobbies = hobbyRepository.findByCategoryAndKeyword(category, keyword);
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
}
