package com.bookshop.bookshopmanagement.repository;

import com.bookshop.bookshopmanagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
