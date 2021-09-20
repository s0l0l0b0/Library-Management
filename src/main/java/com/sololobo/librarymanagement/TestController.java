package com.sololobo.librarymanagement;

import com.sololobo.librarymanagement.domain.User;
import com.sololobo.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class TestController {
     @Autowired
     UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        Optional<User> userOp = userRepository.findById(1L);
        if (userOp.isPresent()) {
            System.out.println("UserName:" + userOp.get().getName());
        }
        return "home";
    }

}
