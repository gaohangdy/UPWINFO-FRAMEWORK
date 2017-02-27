package com.upi.moudles.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upi.moudles.sys.domain.MUser;

public interface MUserRepository extends JpaRepository<MUser, Integer> {

}
