package com.basic_spring.demo.repository;

import com.basic_spring.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}