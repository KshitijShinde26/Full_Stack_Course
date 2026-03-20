package com.basic_spring.demo.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic_spring.demo.models.Post;
import com.basic_spring.demo.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // Get post by ID
    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    // Get all posts
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    // Delete post
    public void delete(Post post) {
        postRepository.delete(post);
    }

    // Save post
    public Post save(Post post) {

        if (post.getId() == null) {
            post.setCreatedAt(LocalDateTime.now());
        }

        return postRepository.save(post);
    }
}