package com.basic_spring.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.basic_spring.demo.config.CustomUserDetails;
import com.basic_spring.demo.model.Account;
import com.basic_spring.demo.services.AccountService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountService accountService;

    public CustomUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Account account = accountService.findByEmail(email);

        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetails(account);
    }
}