package com.basic_spring.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.basic_spring.demo.model.Account;
import com.basic_spring.demo.services.AccountService;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        Account user = new Account();
        user.setEmail("user@gmail.com");
        user.setPassword(passwordEncoder.encode("password"));
        user.setRole("ROLE_USER");

        Account admin = new Account();
        admin.setEmail("admin@gmail.com");
        admin.setPassword(passwordEncoder.encode("password"));
        admin.setRole("ROLE_ADMIN");

        accountService.save(user);
        accountService.save(admin);
    }
}