package com.JBDL.RestDemoLibrary.service;

import com.JBDL.RestDemoLibrary.domain.Book;

import java.util.List;

public interface DBService {
    public Book addBook(Book book);
    public List<Book> getAllBooks();
}
