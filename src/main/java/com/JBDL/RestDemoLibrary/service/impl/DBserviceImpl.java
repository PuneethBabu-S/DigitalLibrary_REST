package com.JBDL.RestDemoLibrary.service.impl;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.domain.Genre;
import com.JBDL.RestDemoLibrary.service.DBService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DBserviceImpl implements DBService {

    @Autowired
    Connection mySQLConnection;

    private PreparedStatement addBookStatement = null;

    @PostConstruct
    public void init() throws SQLException {
        try{
            addBookStatement = mySQLConnection.prepareStatement("INSERT INTO book (title, author, genre, rating, cost, year) VALUES (?, ?, ?, ?, ?, ?)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Book addBook(Book book) {
        try {
            addBookStatement.setString(1, book.getTitle());
            addBookStatement.setString(2, book.getAuthor());
            addBookStatement.setString(3, book.getGenre().toString());
            addBookStatement.setDouble(4, book.getRating());
            addBookStatement.setDouble(5, book.getCost());
            addBookStatement.setInt(6, book.getYear());
            addBookStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        String query = "SELECT * FROM book";
        try(Statement statement = mySQLConnection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            List<Book> books = new ArrayList<>();
            while(resultSet.next()){
                Book book = new Book();
                book.setBookId(resultSet.getString("bookId"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setGenre(Genre.valueOf(resultSet.getString("genre")));
                book.setRating(resultSet.getDouble("rating"));
                book.setCost(resultSet.getDouble("cost"));
                book.setYear(resultSet.getInt("year"));
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
