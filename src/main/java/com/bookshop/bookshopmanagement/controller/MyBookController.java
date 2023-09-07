package com.bookshop.bookshopmanagement.controller;

import com.bookshop.bookshopmanagement.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookController {
    @Autowired
    private MyBookService myBookService;

    @GetMapping ("/delete/{id}")
    public String delete(@PathVariable("id")long id){
        myBookService.deleteById(id);
        return "redirect:/my_book";

    }
}
