package com.bookshop.bookshopmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "MyBook")
public class MyBook {
    @Id
    private String bookName;
    private String author;
    private String dateOfPublication;
    private double price;

    public MyBook(String bookName, String author, String dateOfPublication, double price) {
        this.bookName = bookName;
        this.author = author;
        this.dateOfPublication = dateOfPublication;
        this.price = price;
    }

    public MyBook() {
        super();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}