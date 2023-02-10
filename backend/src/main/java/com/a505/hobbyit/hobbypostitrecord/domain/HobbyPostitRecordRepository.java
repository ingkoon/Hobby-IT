package com.a505.hobbyit.hobbypostitrecord.domain;

import com.a505.hobbyit.hobby.domain.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HobbyPostitRecordRepository extends JpaRepository<HobbyPostitRecord, Long> {
    List<HobbyPostitRecord> findByHobbyAndYearAndMonth(Hobby hobby, int year, int month);
}
