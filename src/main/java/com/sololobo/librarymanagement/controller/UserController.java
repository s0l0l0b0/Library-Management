package com.sololobo.librarymanagement.controller;

import com.sololobo.librarymanagement.domain.Book;
import com.sololobo.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class UserController {

    @Autowired
    BookRepository bookRepository;


    @GetMapping("/user")
    public ModelAndView adminHomePage() {
        List<Book> findAllBook = bookRepository.findAll();
        return new ModelAndView("user")
                .addObject("book", findAllBook);
    }
}
