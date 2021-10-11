package com.sololobo.librarymanagement.controller;

import com.sololobo.librarymanagement.domain.Book;
import com.sololobo.librarymanagement.domain.User;
import com.sololobo.librarymanagement.repository.BookRepository;
import com.sololobo.librarymanagement.repository.BorrowLogRepository;
import com.sololobo.librarymanagement.repository.UserRepository;
import com.sololobo.librarymanagement.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller

public class UserController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BorrowLogRepository borrowLogRepository;
    @Autowired
    UserRepository userRepository;


    @GetMapping("/user")
    public ModelAndView userHomePage() {
        List<Book> findAllBook = bookRepository.getAvailableBooks();
        String userEmail = Utility.getLoggedInUserEmail();
        Optional<User> userByEmail = userRepository.getUserByEmail(userEmail);
        if (userByEmail.isPresent()){
            User user = userByEmail.get();
            return new ModelAndView("user")
                    .addObject("book", findAllBook)
                    .addObject("borrowLogs",borrowLogRepository.getBorrowLogBy(user.getId()));
        }
        throw new IllegalArgumentException("User not found!");
    }
}
