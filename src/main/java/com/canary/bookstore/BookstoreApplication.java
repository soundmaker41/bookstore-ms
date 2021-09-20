package com.canary.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class BookstoreApplication {




	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);

		//
		Date currDate = new Date();
		System.out.println("Current date:" + currDate.toString());

		//Test code
		//MyMongoClient mongoClient = new MyMongoClient();
		//mongoClient.insertTestData();


	}

}
