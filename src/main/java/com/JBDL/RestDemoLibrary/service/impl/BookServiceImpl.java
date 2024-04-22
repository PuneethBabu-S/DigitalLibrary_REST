package com.JBDL.RestDemoLibrary.service.impl;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.domain.Review;
import com.JBDL.RestDemoLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private Connection connection;
    int c = 1, r=1;
    //List<Book> bookList = new java.util.ArrayList<>();
    Map<String, Book> bookMap= new HashMap<>();
    @Override
    public Book addBook(Book book) {
        book.setBookId(String.valueOf(c++));
        bookMap.put(book.getBookId(), book);
        return book;
    }

    @Override
    public void deleteBook(String bookId) {
        bookMap.remove(bookId);
    }

    @Override
    public Book updateBook(String bookId, Book book) {
        bookMap.computeIfPresent(bookId, (k, v) -> {v.setBookId(bookId); return v;});
        return book;
    }

    @Override
    public Map<String, Book> getAllBooks() {
        return bookMap;
    }

    @Override
    public Book getBook(String bookId) {
        return bookMap.getOrDefault(bookId, null);
    }

    @Override
    public void addReview(String bookId, Review review) {
        review.setReviewId(String.valueOf(r++));
        review.setBookId(bookId);
        bookMap.computeIfPresent(bookId, (k, v) -> {v.getReviews().add(review); return v;});
        double sum = bookMap.get(bookId).getReviews().stream().mapToDouble(Review::getRating).sum();
        bookMap.get(bookId).setRating(sum/bookMap.get(bookId).getReviews().size());
    }
}
