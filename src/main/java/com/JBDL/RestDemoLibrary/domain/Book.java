package com.JBDL.RestDemoLibrary.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Author cannot be blank")
    private String author;
    private Genre genre;
    @Min(value = 0, message = "Rating cannot be negative")
    @Max(value = 5, message = "Rating cannot be greater than 5")
    private double rating;
    @Min(value = 0, message = "Cost cannot be negative")
    private double cost;
    @Min(value=1900, message = "Year should be greater than 1900")
    private Integer year;
    private List<Review> reviews = new java.util.ArrayList<>();

    @Override
    public int hashCode() {
       return Integer.valueOf(getBookId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (getBookId() == null) {
            if (other.getBookId() != null)
                return false;
        } else if (!getBookId().equals(other.getBookId()))
            return false;
        return true;
    }

}
