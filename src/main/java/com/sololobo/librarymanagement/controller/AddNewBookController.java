package com.sololobo.librarymanagement.controller;

import com.sololobo.librarymanagement.domain.Book;
import com.sololobo.librarymanagement.domain.enumeration.TypeOfBook;
import com.sololobo.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddNewBookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/addNewBook")
    public ModelAndView newBook(){
        TypeOfBook[] typeOfBooks = TypeOfBook.values();
        return new ModelAndView("addNewBook")
                .addObject("typeOfBooks", typeOfBooks);
    }

    @PostMapping(value= "/addNewBook")
    public ModelAndView postNewBook(Book book){
        bookRepository.save(book);
        return new ModelAndView("redirect:/admin");
    }
}
