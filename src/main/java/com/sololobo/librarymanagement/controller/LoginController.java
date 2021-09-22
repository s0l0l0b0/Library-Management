package com.sololobo.librarymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (Objects.nonNull(authentication)) {
//            return "redirect:/";
//        }
        return "login";
    }
}
