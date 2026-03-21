package com.basic_spring.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/admin")
    public String admin() {
        return "Admin Panel 🔥";
    }

    @GetMapping("/user")
    public String user() {
        return "User Dashboard 👍";
    }
}