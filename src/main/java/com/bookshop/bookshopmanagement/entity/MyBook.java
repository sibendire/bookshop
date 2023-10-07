package com.bookshop.bookshopmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyBook")
public class MyBook {
    @Id
    private long id;
    private String bookName;
    private String author;
    private String dateOfPublication;
    private double price;

    public MyBook( long id, String bookName, String author, String dateOfPublication, double price) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
