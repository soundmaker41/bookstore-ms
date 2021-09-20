package com.canary.bookstore;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class MyMongoClient {

    @Autowired
    private BookstoreRepository bookstoreRepository;

    public void insertTestData(){
        //Insert a test data in code
        /*Book book = new Book();
        book.setAuthor("test1");
        book.setTitle("title");
        book.setSummary("Summary1");
        book.setPublishedDate(new Date());
        book.setRating(3.8f);
        book.setIsbn("978-1-6924-4686-4");

        bookstoreRepository.insert(book);*/
    }
}
