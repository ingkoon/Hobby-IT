package com.a505.hobbyit.hobbypostitrecord.service;

import java.util.List;

public interface HobbyPostitRecordService {
    List<Integer> findHobbyPostitRecords(Long memberId, Long hobbyId, int year, int month);
}
