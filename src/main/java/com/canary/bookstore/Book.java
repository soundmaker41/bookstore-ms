package com.canary.bookstore;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class Book {
    @Id
    private String id;

    //Data Fields for typical book
    private String title;
    private String author;
    private String summary;

    private Date publishedDate;
    private String isbn;

    private float price;
    private float rating;
    private List<String> subjects;

    //

    public Date getPublishedDate() {
        return publishedDate;
    }

    public float getRating() {
        return rating;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getSummary() {
        return summary;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", summary='" + summary + '\'' +
                ", publishedDate=" + publishedDate +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", subjects=" + subjects +
                '}';
    }
}
