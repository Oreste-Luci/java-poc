package com.oresteluci.cassandra.poc;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * @author Oreste Luci
 */
@Table
public class Book {

    @PrimaryKey
    private String isbn;
    private String title;
    private String author;
    private String edition;
    private Integer year;
    private Double price;

    public Book() {
    }

    public Book(String isbn, String title, String author, String edition, Integer year, Double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.year = year;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
