package com.sololobo.librarymanagement.controller;

import com.sololobo.librarymanagement.domain.Book;
import com.sololobo.librarymanagement.domain.User;
import com.sololobo.librarymanagement.repository.BookRepository;
import com.sololobo.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/admin")
    public ModelAndView adminHomePage() {
        List<User> findAllUser = userRepository.findAll();
        List<Book> findAllBoook = bookRepository.findAll();
        return new ModelAndView("admin")
                .addObject("user", findAllUser)
                .addObject("book", findAllBoook);
    }
}
