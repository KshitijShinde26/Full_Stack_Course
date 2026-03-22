package com.basic_spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}