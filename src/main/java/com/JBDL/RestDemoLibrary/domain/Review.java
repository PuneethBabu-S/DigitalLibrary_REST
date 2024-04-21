package com.JBDL.RestDemoLibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private String ReviewId;
    private double rating;
    private String description;
    private String bookId;

    private String reviewer;

}
