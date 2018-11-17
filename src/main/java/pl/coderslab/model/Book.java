package pl.coderslab.model;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;


public class Book {

    private Long id;
    private static AtomicLong longId = new AtomicLong(0);
    private String isbn;
    private String author;
    private String publisher;
    private String type;

    public Book(String isbn, String author, String publisher, String type) {
        this.id = longId.incrementAndGet();
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.type = type;
    }

    public Book() {
        this.id =  this.id = longId.incrementAndGet();
    }
   public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
