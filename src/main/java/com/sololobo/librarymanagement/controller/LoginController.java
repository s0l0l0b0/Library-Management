package com.sololobo.librarymanagement.controller;

import com.sololobo.librarymanagement.utility.Utility;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        if (Utility.isAdminUser()) {
            return "redirect:/admin";
        }
        if (Utility.isLoggedInUser()) {
            return "redirect:/";
        }
        return "login";
    }
}
