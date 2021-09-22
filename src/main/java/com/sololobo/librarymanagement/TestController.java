package com.sololobo.librarymanagement;

import com.sololobo.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class TestController {
     @Autowired
     UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        Authentication name = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = name.getAuthorities();
        authorities.forEach(System.out::println);
        model.addAttribute("name", name);
        return "home";
    }

}
