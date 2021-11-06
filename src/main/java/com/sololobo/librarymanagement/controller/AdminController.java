package com.sololobo.librarymanagement.controller;

import com.sololobo.librarymanagement.domain.Book;
import com.sololobo.librarymanagement.domain.User;
import com.sololobo.librarymanagement.repository.BookRepository;
import com.sololobo.librarymanagement.repository.BorrowLogRepository;
import com.sololobo.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BorrowLogRepository borrowLogRepository;

    @GetMapping("/admin")
    public ModelAndView adminHomePage() {
        List<User> findAllUser = userRepository.findAll();
        List<Book> findAllBook = bookRepository.findAll();
        return new ModelAndView("admin")
                .addObject("user", findAllUser)
                .addObject("book", findAllBook);
    }

    //rest endpoint
    @ResponseBody
    @GetMapping("/activateInactive")
    public void activateUser(@RequestParam Long userId) {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isPresent()) {
            User user = byId.get();
            user.setIsActive(!user.getIsActive());
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User Not Found!");
        }
    }

    @GetMapping("/userBorrowLog")
    public ModelAndView userBorrowLog(@RequestParam String userEmail){
        Optional<User> byId = userRepository.getUserByEmail(userEmail);
        if (byId.isPresent()){
            User user = byId.get();
            return new ModelAndView(("userBorrowLog"))
                    .addObject("borrowLogs", borrowLogRepository.getBorrowLogBy(user.getId()))
                    .addObject("user", user);
        }
        throw new IllegalArgumentException("User not found!");
    }
}
