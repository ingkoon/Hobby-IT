package com.a505.hobbyit.hobby.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {

    @Query("SELECT h "
            + "FROM Hobby h "
            + "WHERE h.category = :category ")
    List<Hobby> findByCategoryAndKeyword(final String category, final String keyword);

    @Query(value = "SELECT * "
            + "FROM HOBBY "
            + "ORDER BY RAND() "
            + "LIMIT 10", nativeQuery = true)
    List<Hobby> findPopularHobby();

    @Query(value = "SELECT * "
            + "FROM HOBBY "
            + "ORDER BY CREATED_DATE, RAND() "
            + "LIMIT 10", nativeQuery = true)
    List<Hobby> findFreshHobby();
}
