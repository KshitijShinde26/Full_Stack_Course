package com.basic_spring.demo.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic_spring.demo.model.User;
import com.basic_spring.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

   

    public void saveUser(User user) {
        repo.save(user);
    }
}
