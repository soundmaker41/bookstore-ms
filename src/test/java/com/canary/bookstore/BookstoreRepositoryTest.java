package com.canary.bookstore;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureDataMongo
public class BookstoreRepositoryTest {

    @Autowired
    private BookstoreRepository bookstoreRepository;

    @Test
    public void findByAuthorContaining_existingAuthor_shouldReturnList(){
        // Given
        // DB with default books
        final String existingBookPartialTitle = "Jack";

        // When
        //final List<Book> books = bookstoreRepository.findByAuthorContaining(existingBookPartialTitle);

        // Then
//        final int expectedCount = 0;
//        Assert.assertEquals(expectedCount, books.size());
//        Assert.assertEquals(books.size(), books.stream().filter(
//                b -> b.getTitle().contains(existingBookPartialTitle)).count());
    }

}
