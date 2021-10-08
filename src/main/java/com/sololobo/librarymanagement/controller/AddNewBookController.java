package com.sololobo.librarymanagement.controller;

import com.sololobo.librarymanagement.domain.Book;
import com.sololobo.librarymanagement.domain.enumeration.TypeOfBook;
import com.sololobo.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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
        book.setAvailable(1);
        bookRepository.save(book);
        return new ModelAndView("redirect:/admin");
    }

    @GetMapping("/editBook")
    public ModelAndView editBook(@RequestParam Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        ModelAndView modelAndView = new ModelAndView("addNewBook");
        optionalBook.ifPresent(book -> modelAndView.addObject("book", book));
        return modelAndView
                .addObject("typeOfBooks", TypeOfBook.values());
    }
}
