package com.JBDL.RestDemoLibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "reviews")
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;
    private double rating;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "book_bookId")
    @JsonIgnoreProperties("reviews")
    private Book book;
    //private String reviewer;

}
