package com.basic_spring.demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.basic_spring.demo.model.Account;
import com.basic_spring.demo.repository.AccountRepository;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    // ✅ SAVE METHOD
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    // ✅ LOGIN METHOD (Spring uses this automatically)
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Optional<Account> optionalAccount =
                accountRepository.findOneByEmailIgnoreCase(username);

        if (optionalAccount.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        Account account = optionalAccount.get();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(account.getRole()));

        return new org.springframework.security.core.userdetails.User(
                account.getEmail(),
                account.getPassword(),
                authorities
        );
    }
}