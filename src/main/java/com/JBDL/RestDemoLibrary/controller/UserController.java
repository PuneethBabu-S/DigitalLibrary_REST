package com.JBDL.RestDemoLibrary.controller;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.domain.User;
import com.JBDL.RestDemoLibrary.service.BookService;
import com.JBDL.RestDemoLibrary.service.UserService;
import com.JBDL.RestDemoLibrary.service.resource.UserRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody @Valid UserRequest user){
        return new ResponseEntity<>(userService.addUser(user.getUser()), HttpStatus.CREATED);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity updateUser(@PathVariable("userId") Integer userId,@RequestBody @Valid UserRequest user){
        return new ResponseEntity<>(userService.updateUser(userId, user.getUser()) ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") Integer userId){
        return new ResponseEntity<>(userService.getUser(userId),HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("book/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable("bookId") Integer bookId) {
        return new ResponseEntity<>(bookService.getBook(bookId), HttpStatus.OK);
    }
    @GetMapping("books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

//    @PostMapping("review")
//    public ResponseEntity addReview(@RequestParam("bookId") String bookId, @RequestBody Review review) {
//        bookService.addReview(bookId, review);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}
