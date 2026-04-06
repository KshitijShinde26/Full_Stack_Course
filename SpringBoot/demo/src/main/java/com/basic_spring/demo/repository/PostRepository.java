package com.basic_spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic_spring.demo.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}