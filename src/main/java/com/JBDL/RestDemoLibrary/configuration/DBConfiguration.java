package com.JBDL.RestDemoLibrary.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBConfiguration {

    @Value("${mysql-url}")
    private String url;
    @Value("${mysql-username}")
    private String username;
    @Value("${mysql-password}")
    private String password;
    @Bean("Database")
    public Connection mySQLConnection(){
        Connection connection = null;
        try {
            //"jdbc:mysql://localhost:3306/library"
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
