package com.basic_spring.demo.controller;

import com.basic_spring.demo.model.User;
import com.basic_spring.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @Valid @ModelAttribute("user") User user,
            BindingResult result) {

        if (result.hasErrors()) {
            return "register";
        }

        service.saveUser(user);
        return "success";
    }
}