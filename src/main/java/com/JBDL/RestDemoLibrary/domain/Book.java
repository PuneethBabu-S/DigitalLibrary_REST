package com.JBDL.RestDemoLibrary.domain;

import jakarta.persistence.*;
import lombok.*;

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
    private Integer BookId;
    private String title;
    private String author;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private double rating;
    private double cost;
    private Integer year;
}
