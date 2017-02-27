package com.upi.moudles.biz.repository;

import com.upi.moudles.biz.domain.MCode;
import com.upi.moudles.biz.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
