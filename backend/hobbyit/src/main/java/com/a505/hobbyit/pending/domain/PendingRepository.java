package com.a505.hobbyit.pending.domain;

import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PendingRepository extends JpaRepository<Pending, Long> {

}
