package com.JBDL.RestDemoLibrary.repository;

import com.JBDL.RestDemoLibrary.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByAuthorAndGenre(String author, String genre);
    //List<Book> findByAuthorGroupBy(String author,Double rating);
    Page<Book> findByRating(Double rating, Pageable pageable);
    @Query("select book from Book book where title like ?1")
    List<Book> findByTitleLike(String title);
    @Query("select book from Book book where title like :title")
    List<Book> findByTitleLike2(String title);
    List<Book> findByRatingGreaterThan(double rating);
    @Query(value="select * from books where rating > ?",nativeQuery = true)
    List<Book> giveMeTopBooks(Double rating);
}
