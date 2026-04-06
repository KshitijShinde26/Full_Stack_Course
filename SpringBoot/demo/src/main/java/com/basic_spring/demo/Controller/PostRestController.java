package com.basic_spring.demo.controller;


import org.springframework.web.bind.annotation.*;

import com.basic_spring.demo.model.Post;
import com.basic_spring.demo.services.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostRestController {

    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }
}
