package com.JBDL.RestDemoLibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String title;
    private String author;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private double rating;
    private double cost;
    private Integer year;
    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties("book")
    private List<Review> reviews;
}
