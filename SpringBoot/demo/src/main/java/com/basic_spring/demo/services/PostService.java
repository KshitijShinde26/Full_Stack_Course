package com.basic_spring.demo.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic_spring.demo.model.Post;
import com.basic_spring.demo.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public  Post save(Post post) {
        if (post.getCreatedAt() == null) {
            post.setUpdatedAt(LocalDateTime.now());
        }
        post.setUpdatedAt(LocalDateTime.now());
        return repo.save(post);
    }

    public Optional<Post> getById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}