package com.basic_spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.basic_spring.demo.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}