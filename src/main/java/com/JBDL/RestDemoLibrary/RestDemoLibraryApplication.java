package com.JBDL.RestDemoLibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestDemoLibraryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoLibraryApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		Book book = new Book();
//		book.setBookId("1");
//		book.setTitle("Book 1");
//		book.setAuthor("Author 1");
//		book.setGenre(Genre.FICTION);
//		book.setRating(4.5);
//		book.setCost(10.0);
//		book.setYear(2020);
//
//		Book book2 = new Book();
//		book2.setBookId("1");
//		book2.setTitle("Book 1");
//		book2.setAuthor("Author 1");
//		book2.setGenre(Genre.FICTION);
//		book2.setRating(4.5);
//		book2.setCost(10.0);
//		book2.setYear(2020);
//
//		Set<Book> bookSet = new HashSet<>();
//		bookSet.add(book);
//		bookSet.add(book);
//		bookSet.add(book2);
//
//		System.out.println(bookSet.size());
	}
}
