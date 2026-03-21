package com.basic_spring.demo.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.basic_spring.demo.model.Post;
import com.basic_spring.demo.services.PostService;



@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model, Principal principal) {

        Optional<Post> optionalPost = postService.getById(id);

        if (optionalPost.isPresent()) {

            Post post = optionalPost.get();
            model.addAttribute("post", post);

            // Check owner
            boolean isOwner = false;

            if (principal != null) {
                String loggedUser = principal.getName();

                if (loggedUser.equals(post.getAccount().getEmail())) {
                    isOwner = true;
                }
            }

            model.addAttribute("isOwner", isOwner);

            return "post_views/post";

        } else {
            return "404";
        }
    }
}