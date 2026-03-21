package com.basic_spring.demo.services;

import org.springframework.stereotype.Service;

import com.basic_spring.demo.model.Account;
import com.basic_spring.demo.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }
}