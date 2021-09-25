package com.sololobo.librarymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminHomePage() {
        return "admin";
    }
}
