package com.JBDL.RestDemoLibrary.service.resource;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.domain.Genre;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.convert.ValueConverter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Author cannot be blank")
    private String author;
    @ValueConverter
    private Genre genre;
    @Min(value = 0, message = "Cost cannot be negative")
    private double cost;
    @Min(value = 1900, message = "Year should be greater than 1900")
    @Max(value = 2024, message = "Year should be less than current year")
    private Integer year;

    public Book getBook() {
        return Book.builder().title(this.title).author(this.author).
                genre(this.genre).cost(this.cost).year(this.year).
                rating(0.0).build();
    }
}
