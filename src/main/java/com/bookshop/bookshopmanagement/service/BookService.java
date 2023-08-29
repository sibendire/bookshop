package com.bookshop.bookshopmanagement.service;

import com.bookshop.bookshopmanagement.entity.Book;
import com.bookshop.bookshopmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface  BookService {
Book saveBook(Book book);



}
