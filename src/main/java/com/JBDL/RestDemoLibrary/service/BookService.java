package com.JBDL.RestDemoLibrary.service;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.domain.Review;

import java.util.Map;

public interface BookService {
    public Book addBook(Book book);
    public void deleteBook(String bookId);
    public Book updateBook(String bookId, Book book);
    public Map<String, Book> getAllBooks();
    public Book getBook(String bookId);
    public void addReview(String bookId, Review review);
}
