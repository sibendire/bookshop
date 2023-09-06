package com.bookshop.bookshopmanagement.service;

import com.bookshop.bookshopmanagement.entity.MyBook;
import com.bookshop.bookshopmanagement.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
    private MyBookRepository myBookRepository;
    public  void saveMyBook(MyBook myBook){

        myBookRepository.save(myBook);
    }
    public List<MyBook> getAllMyBooks(){
        return myBookRepository.findAll();
    }
}
