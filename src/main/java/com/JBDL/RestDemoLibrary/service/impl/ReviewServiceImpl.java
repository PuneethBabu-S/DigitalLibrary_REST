package com.JBDL.RestDemoLibrary.service.impl;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.domain.Review;
import com.JBDL.RestDemoLibrary.repository.BookRepository;
import com.JBDL.RestDemoLibrary.repository.ReviewRepository;
import com.JBDL.RestDemoLibrary.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public Review addReview(Review review) {
        Optional<Book> book = bookRepository.findById(review.getBook().getBookId());
        if(book.isEmpty()){
            throw new IllegalArgumentException("BookId doesn't exist");
        }
        review.setBook(book.get());
        reviewRepository.save(review);
        return review;
    }
}
