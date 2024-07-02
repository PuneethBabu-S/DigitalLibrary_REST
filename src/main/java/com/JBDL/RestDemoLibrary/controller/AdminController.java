package com.JBDL.RestDemoLibrary.controller;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.service.BookService;
import com.JBDL.RestDemoLibrary.service.resource.BookRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    BookService bookService;

    @PostMapping("admin/book")
    public ResponseEntity<Book> addBook(@RequestBody @Valid BookRequest bookRequest) {
        return new ResponseEntity<>(bookService.addBook(bookRequest.getBook()), HttpStatus.CREATED);
    }

    @DeleteMapping("admin/book")
    public ResponseEntity deleteBook(@RequestParam("bookId") Integer bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @PutMapping("admin/book")
    public ResponseEntity updateBook(@RequestParam("bookId") Integer bookId, @RequestBody @Valid BookRequest bookRequest) {
        //Book res = null;
        //res = bookService.updateBook(bookId, bookRequest.getBook());
        //Boolean present = bookService.updateBook(bookId, bookRequest.getBook());
        return new ResponseEntity<>( bookService.updateBook(bookId, bookRequest.getBook()) ? HttpStatus.CREATED : HttpStatus.NO_CONTENT);
    }
}
