package com.JBDL.RestDemoLibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String BookId;
    private String title;
    private String author;
    private Genre genre;
    private double rating;
    private double cost;
    private Integer year;
    private List<Review> reviews = new java.util.ArrayList<>();
}
