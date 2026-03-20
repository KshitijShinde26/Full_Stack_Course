package com.basic_spring.demo.repository;



import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.basic_spring.demo.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
