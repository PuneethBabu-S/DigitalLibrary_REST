package com.JBDL.RestDemoLibrary.controller;

import com.JBDL.RestDemoLibrary.domain.Review;
import com.JBDL.RestDemoLibrary.service.BookService;
import com.JBDL.RestDemoLibrary.service.ReviewService;
import com.JBDL.RestDemoLibrary.service.resource.ReviewRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    BookService bookService;
    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody @Valid ReviewRequest reviewRequest){
        return new ResponseEntity<>(reviewService.addReview(reviewRequest.toReview()), HttpStatus.CREATED);
    }
}
