package com.JBDL.RestDemoLibrary.controller;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.domain.Review;
import com.JBDL.RestDemoLibrary.domain.User;
import com.JBDL.RestDemoLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    BookService bookService;
    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("book/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable("bookId") String bookId) {
        return new ResponseEntity<>(bookService.getBook(bookId), HttpStatus.OK);
    }
    @GetMapping("books")
    public ResponseEntity<Map<String,Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping("review")
    public ResponseEntity addReview(@RequestParam("bookId") String bookId, @RequestBody Review review) {
        bookService.addReview(bookId, review);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
