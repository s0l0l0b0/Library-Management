package com.sololobo.librarymanagement.controller;

import com.sololobo.librarymanagement.utility.Utility;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.security.web.WebAttributes.AUTHENTICATION_EXCEPTION;


@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        AuthenticationException ae = (AuthenticationException) request.getSession().getAttribute(AUTHENTICATION_EXCEPTION);
        if (ae != null){
            model.addAttribute("error_msg", ae.getMessage());
        }

        if (Utility.isAdminUser()) {
            return "redirect:/admin";
        }
        if (Utility.isLoggedInUser()) {
            return "redirect:/user";
        }
        return "login";
    }
}
