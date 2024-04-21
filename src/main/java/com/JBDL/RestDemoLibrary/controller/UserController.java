package com.JBDL.RestDemoLibrary.controller;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.domain.Review;
import com.JBDL.RestDemoLibrary.domain.User;
import com.JBDL.RestDemoLibrary.service.BookService;
import com.JBDL.RestDemoLibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;
    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") String userId,@RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(userId, user), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId){
        return new ResponseEntity<>(userService.getUser(userId),HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<Map<String,User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
