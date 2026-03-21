package com.basic_spring.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.basic_spring.demo.config.CustomUserDetails;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication auth, Model model) {

        CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
        model.addAttribute("email", user.getUsername());

        return "dashboard";
    }
}