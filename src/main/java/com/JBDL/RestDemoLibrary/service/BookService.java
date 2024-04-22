package com.JBDL.RestDemoLibrary.service;

import com.JBDL.RestDemoLibrary.domain.Book;

import java.util.List;

public interface BookService {
    public Book addBook(Book book);
    public void deleteBook(Integer bookId);
    public Book updateBook(Integer bookId, Book book);
    public List<Book> getAllBooks();
    public Book getBook(Integer bookId);
    //public void addReview(String bookId, Review review);
}
