package com.basic_spring.demo.services;

import java.util.Optional;
import com.basic_spring.demo.model.Account;

public interface AccountService {

    Optional<Account> findByEmail(String email);

    Optional<Account> findByPasswordResetToken(String token);

    Optional<Account> findById(Long id);

    void save(Account account);
}