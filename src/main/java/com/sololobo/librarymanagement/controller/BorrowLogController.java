package com.sololobo.librarymanagement.controller;

import com.sololobo.librarymanagement.domain.Book;
import com.sololobo.librarymanagement.domain.BorrowLog;
import com.sololobo.librarymanagement.domain.User;
import com.sololobo.librarymanagement.repository.BookRepository;
import com.sololobo.librarymanagement.repository.BorrowLogRepository;
import com.sololobo.librarymanagement.repository.UserRepository;
import com.sololobo.librarymanagement.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;


@Controller
public class BorrowLogController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BorrowLogRepository borrowLogRepository;

    @ResponseBody
    @PostMapping("/borrow")
    @Transactional
    public ModelAndView borrow(@RequestParam Long bookId, RedirectAttributes redirectAttributes){
        BorrowLog borrowLog = new BorrowLog();
        String email = Utility.getLoggedInUserEmail();
        Optional<User> userByEmail = userRepository.getUserByEmail(email);
        Optional<Book> byBookId = bookRepository.findById(bookId);

        if (userByEmail.isPresent() && byBookId.isPresent()){
            if (borrowLogRepository.getBorrowCountByUserId(userByEmail.get().getId())< Utility.borrowLimit(userByEmail.get())){
                borrowLog.setUserId(userByEmail.get().getId());
                borrowLog.setBookId(bookId);
                borrowLog.setDate(LocalDateTime.now());
                Book book = byBookId.get();
                book.setAvailable(0);
                borrowLogRepository.save(borrowLog);
                bookRepository.save(book);
            }else {
                redirectAttributes.addFlashAttribute("errorMsg", "Reached Borrow Limit!");
            }

        }else {
            redirectAttributes.addFlashAttribute("errorMsg", "Illegal Operation!");
        }
        return new ModelAndView("redirect:/user");
    }

    @ResponseBody
    @GetMapping("/return")
    @Transactional
    public String returnBook(@RequestParam Long borrowLogId){
        String email = Utility.getLoggedInUserEmail();
        Optional<User> userByEmail = userRepository.getUserByEmail(email);
        Optional<BorrowLog> byId = borrowLogRepository.findById(borrowLogId);
        if (byId.isPresent()){
            BorrowLog borrowLog = byId.get();
            if (userByEmail.isPresent()){
                if (borrowLog.getUserId().equals(userByEmail.get().getId())){
                    Book book = borrowLog.getBook();
                    book.setAvailable(1);
                    bookRepository.save(book);
                    borrowLogRepository.delete(borrowLog);


                    int fine = Utility.calculateFine(byId.get());
                    if (fine > 0){
                        return "Your fine is: " + (NumberFormat.getCurrencyInstance(Locale.CHINA).format(fine));
                    }
                }
            }
        }
        return null;
    }
}
