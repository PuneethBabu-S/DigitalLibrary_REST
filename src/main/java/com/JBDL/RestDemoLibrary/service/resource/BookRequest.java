package com.JBDL.RestDemoLibrary.service.resource;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.domain.Genre;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Author cannot be blank")
    private String author;
    private Genre genre;
    @Min(value = 0, message = "Cost cannot be negative")
    private double cost;
    @Min(value=1900, message = "Year should be greater than 1900")
    private Integer year;

    public Book getBook() {
        return Book.builder().title(title).author(author).genre(genre).cost(cost).year(year).rating(0.0).build();
    }
}
