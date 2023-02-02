package com.a505.hobbyit.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);
    @Query(value = "SELECT m "
            + "FROM Member m "
            + "WHERE m.email like :email "
            + "and m.name like :name")
    Optional<Member> findByEmailAndName (String email, String name);
}
