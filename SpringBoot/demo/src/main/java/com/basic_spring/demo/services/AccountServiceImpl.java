package com.basic_spring.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic_spring.demo.model.Account;
import com.basic_spring.demo.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repo;

    public Optional<Account> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public Optional<Account> findByPasswordResetToken(String token) {
        return repo.findByPasswordResetToken(token);
    }

    public Optional<Account> findById(Long id) {
        return repo.findById(id);
    }

    public void save(Account account) {
        repo.save(account);
    }
}