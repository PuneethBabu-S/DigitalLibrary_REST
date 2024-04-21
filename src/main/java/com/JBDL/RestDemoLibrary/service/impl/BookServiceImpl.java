package com.JBDL.RestDemoLibrary.service.impl;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.domain.Review;
import com.JBDL.RestDemoLibrary.service.BookService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    int c = 1, r=1;
    List<Book> bookList = new java.util.ArrayList<>();
    Map<String, Book> bookMap= new HashMap<>();
    @Override
    public Book addBook(Book book) {
        book.setBookId(String.valueOf(c++));
        //bookList.add(book);
        bookMap.put(book.getBookId(), book);
        return book;
    }

    @Override
    public void deleteBook(String bookId) {
        bookMap.remove(bookId);
//        int index = -1;
//        System.out.println("Going here");
//        for(int i = 0; i< bookList.size(); i++){
//            if(bookList.get(i).getBookId().equals(bookId)){
//                index = i;
//                //System.out.println("Book found");
//                break;
//            }
//        }
//        if(index>-1){
//            bookList.remove(index);
//        }
    }

    @Override
    public Book updateBook(String bookId, Book book) {
//        int index = -1;
//        for(int i = 0; i< bookList.size(); i++){
//            if(bookList.get(i).getBookId().equals(bookId)){
//                index = i;
//                break;
//            }
//        }
//        if(index>-1){
//            String bookId1 = bookList.get(index).getBookId();
//            book.setBookId(bookId1);
//            bookList.set(index, book);
//            return book;
//        }
        bookMap.computeIfPresent(bookId, (k, v) -> book);
//      bookMap.put(bookId, book);
        return null;
    }

    @Override
    public Map<String, Book> getAllBooks() {
        return bookMap;
    }

    @Override
    public Book getBook(String bookId) {
//        int index = -1;
//        for(int i = 0; i< bookList.size(); i++){
//            if(bookList.get(i).getBookId().equals(bookId)){
//                index = i;
//                break;
//            }
//        }
//        if(index>-1){
//            return bookList.get(index);
//        }
        return bookMap.getOrDefault(bookId, null);
    }

    @Override
    public void addReview(String bookId, Review review) {
        review.setReviewId(String.valueOf(r++));
        review.setBookId(bookId);
        bookMap.computeIfPresent(bookId, (k, v) -> {v.getReviews().add(review); return v;});
        double sum = bookMap.get(bookId).getReviews().stream().mapToDouble(x -> x.getRating()).sum();
        bookMap.get(bookId).setRating(sum/bookMap.get(bookId).getReviews().size());
//        int index = -1;
//        for(int i = 0; i< bookList.size(); i++){
//            if(bookList.get(i).getBookId().equals(bookId)){
//                index = i;
//                break;
//            }
//        }
//        if(index>-1){
//            List<Review> r = bookList.get(index).getReviews();
//            if(r!=null) {
//                r.add(review);
//            }
//            else{
//                r = new java.util.ArrayList<>();
//                r.add(review);
//            }
//            bookList.get(index).setReviews(r);

            //double sum = r.stream().map(x -> x.getRating()).reduce(0.0, (a,b) -> a + b);

//            double sum = 0.0;
//            for(int i = 0; i< r.size(); i++){
//                sum += r.get(i).getRating();
//            }
//            bookList.get(index).setRating(sum/r.size());
//        }
    }
}
