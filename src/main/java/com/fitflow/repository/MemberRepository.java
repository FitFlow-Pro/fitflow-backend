package com.fitflow.repository;

import com.fitflow.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUser_Email(String email);

    boolean existsByUser_Email(String email);

    Optional<Member> findByUser_Id(Long userId);
}
