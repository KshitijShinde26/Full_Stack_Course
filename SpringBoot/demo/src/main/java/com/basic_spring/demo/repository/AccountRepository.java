package com.basic_spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic_spring.demo.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByEmail(String email);
}