package com.basic_spring.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.basic_spring.demo.model.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
