package com.basic_spring.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic_spring.demo.model.Authority;
import com.basic_spring.demo.repository.AuthorityRepository;



@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority save(Authority authority) {
        return authorityRepository.save(authority);
    }

    public Optional<Authority> findById(Long id) {
        return authorityRepository.findById(id);
    }
}
