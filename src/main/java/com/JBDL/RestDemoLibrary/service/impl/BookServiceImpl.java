package com.JBDL.RestDemoLibrary.service.impl;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.repository.BookRepository;
import com.JBDL.RestDemoLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    int c = 1, r=1;
    //List<Book> bookList = new java.util.ArrayList<>();
    //Map<String, Book> bookMap= new HashMap<>();
    @Override
    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book updateBook(Integer bookId, Book book) {
        Optional<Book> originalBook = bookRepository.findById(bookId);
        if (originalBook.isPresent()) {
            book.setBookId(bookId);
            bookRepository.save(book);
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Integer bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

//    @Override
//    public void addReview(String bookId, Review review) {
//        review.setReviewId(String.valueOf(r++));
//        review.setBookId(bookId);
//        bookMap.computeIfPresent(bookId, (k, v) -> {v.getReviews().add(review); return v;});
//        double sum = bookMap.get(bookId).getReviews().stream().mapToDouble(Review::getRating).sum();
//        bookMap.get(bookId).setRating(sum/bookMap.get(bookId).getReviews().size());
//    }
}
