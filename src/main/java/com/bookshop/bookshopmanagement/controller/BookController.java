package com.bookshop.bookshopmanagement.controller;


import com.bookshop.bookshopmanagement.entity.Book;
import com.bookshop.bookshopmanagement.service.BookService;
import com.bookshop.bookshopmanagement.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    Autowired
    private MyBookService myBookService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAlleBooks() {
        List<Book> list = bookService.getAllBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookList");
        modelAndView.addObject("book", list);
        return modelAndView;

    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute @Validated Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "bookRegister";
        } else {

            bookService.save(book);
            return "redirect:/available_books";
        }
    }

    @GetMapping("/my_book")
    public String getMyBook() {
        return "my_book";
    }


    @RequestMapping("/my_book/{id}")
    public String getBookList(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(book.getId(),book.getBookName(),book.getAuthor(),
                book.getDateOfPublication(),book.getPrice());
        myBookList.


    }

}
