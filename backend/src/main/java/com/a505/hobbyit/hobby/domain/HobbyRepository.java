package com.a505.hobbyit.hobby.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {

    Boolean existsByName(String name);

    @Query("SELECT h "
            + "FROM Hobby h "
            + "WHERE h.name = :keyword "
            + "OR h.category = :keyword")
    List<Hobby> findByKeyword(final String keyword);

    List<Hobby> findByNameLikeOrCategoryLike(String name, String category, Pageable pageable);

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
