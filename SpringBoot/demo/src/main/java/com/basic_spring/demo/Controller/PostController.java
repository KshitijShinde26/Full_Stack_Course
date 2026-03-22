package com.basic_spring.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.basic_spring.demo.model.Post;
import com.basic_spring.demo.services.PostService;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    // Show Add Post Page
    @GetMapping("/add")
    public String showAddPostPage(Model model) {
        model.addAttribute("post", new Post());
        return "post/post_add";
    }

    // Handle Add Post (simple)
    @PostMapping("/post_add")
    public String savePost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/add";
    }

    // Handle Add Post (secured version)
    @PostMapping("/posts/add")
    @PreAuthorize("isAuthenticated()")
    public String addPost(@ModelAttribute Post post, Principal principal) {

        String authUser = "";

        if (principal != null) {
            authUser = principal.getName();
        }

        // security check
        if (!post.getEmail().equalsIgnoreCase(authUser)) {
            return "redirect:/?error";
        }

        postService.save(post);

        return "redirect:/posts/" + post.getId();
    }
}