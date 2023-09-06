package com.bookshop.bookshopmanagement.repository;

import com.bookshop.bookshopmanagement.entity.MyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBook,Long> {
}