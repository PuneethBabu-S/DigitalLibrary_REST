package com.JBDL.RestDemoLibrary.controller;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    BookService bookService;
    @PostMapping("admin/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("admin/book")
    public ResponseEntity deleteBook(@RequestParam("bookId") String bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @PutMapping("admin/book")
    public ResponseEntity<Book> updateBook(@RequestParam("bookId") String bookId, @RequestBody Book book) {
        return new ResponseEntity<>(bookService.updateBook(bookId, book), HttpStatus.OK);
    }
}
