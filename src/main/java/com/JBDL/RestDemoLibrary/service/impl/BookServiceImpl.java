package com.JBDL.RestDemoLibrary.service.impl;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.domain.Review;
import com.JBDL.RestDemoLibrary.repository.BookRepository;
import com.JBDL.RestDemoLibrary.repository.ReviewRepository;
import com.JBDL.RestDemoLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ReviewRepository reviewRepository;

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
    public Boolean updateBook(Integer bookId, Book book) {
        Optional<Book> originalBook = bookRepository.findById(bookId);
        if (originalBook.isPresent()) {
            book.setBookId(bookId);
            bookRepository.save(book);
        }
        return originalBook.isPresent();
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
//    public Review addReview(Review review) {
//        reviewRepository.save(review);
//        return review;
////        Integer bookId = review.getBookId();
////        review.setReviewId(String.valueOf(r++));
////        review.setBookId(bookId);
////        bookMap.computeIfPresent(bookId, (k, v) -> {v.getReviews().add(review); return v;});
////        double sum = bookMap.get(bookId).getReviews().stream().mapToDouble(Review::getRating).sum();
////        bookMap.get(bookId).setRating(sum/bookMap.get(bookId).getReviews().size());
//    }
}
