package com.basic_spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}