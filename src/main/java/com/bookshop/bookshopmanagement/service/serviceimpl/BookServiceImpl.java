package com.bookshop.bookshopmanagement.service.serviceimpl;

import com.bookshop.bookshopmanagement.entity.Book;
import com.bookshop.bookshopmanagement.repository.BookRepository;
import com.bookshop.bookshopmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImpl implements BookService {
    @Autowired
    private  final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
     return bookRepository.save(book);
    }
}
