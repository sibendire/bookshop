package com.bookshop.bookshopmanagement.controller;

import com.bookshop.bookshopmanagement.entity.Book;
import com.bookshop.bookshopmanagement.entity.MyBook;
import com.bookshop.bookshopmanagement.service.BookService;
import com.bookshop.bookshopmanagement.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookService myBookService;

    private List<Book> selectedBooks = new ArrayList<>();


    @GetMapping("/")
    public String home() {
        return "redirect:/account";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks() {
        List<Book> list = bookService.getAllBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookList");
        modelAndView.addObject("books", list);
        return modelAndView;
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute @Validated Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "bookRegister"; // Return to the registration page for validation errors
        }

        String dateText = book.getDateOfPublication(); // Get the date text from the book object

        if (dateText != null && !dateText.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(dateText);
                book.setDateOfPublication(String.valueOf(parsedDate));
            } catch (ParseException e) {
                bindingResult.rejectValue("dateOfPublication", "error.dateOfPublication", "Invalid date format");
                return "bookRegister"; // Return to the registration page for date parsing errors
            }
        } else {
            bindingResult.rejectValue("dateOfPublication", "error.dateOfPublication", "Date is required");
            return "bookRegister"; // Return to the registration page for missing date
        }

        bookService.save(book);
        return "redirect:/available_books"; // Redirect to the book list page on successful submission
    }



    @GetMapping("/my_book")
    public String getMyBook(Model model) {
        List<MyBook> list = myBookService.getAllMyBooks();
        model.addAttribute("myBooks", list);
        return "myBook";
    }

    @RequestMapping("/my_book/{id}")
    public String addBookToCollection(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        MyBook myBook = new MyBook(book.getId(), book.getBookName(), book.getAuthor(),
                book.getDateOfPublication(), book.getPrice());
        myBookService.saveMyBook(myBook);
        selectedBooks.add(book);
        return "redirect:/available_books"; // Redirect to the correct URL
    }

    @RequestMapping("/edit_book/{id}")
    public String editBook(@PathVariable("id") long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        bookService.deleteById(id);
        return "redirect:/available_books";
    }
}
