package com.basic_spring.demo.services;


import org.springframework.stereotype.Service;

import com.basic_spring.demo.model.Post;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    public List<Post> findAll() {
        return Arrays.asList(
                new Post(1, "First Post"),
                new Post(2, "Second Post"),
                new Post(3, "Third Post")
        );
    }
}