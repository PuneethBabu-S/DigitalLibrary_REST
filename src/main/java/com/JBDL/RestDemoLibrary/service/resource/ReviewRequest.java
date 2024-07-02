package com.JBDL.RestDemoLibrary.service.resource;

import com.JBDL.RestDemoLibrary.domain.Book;
import com.JBDL.RestDemoLibrary.domain.Review;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    @Min(value = 0,message = "Cannot be less than 0")
    private Integer bookId;
    @NotBlank
    private String comment;
    @Min(value = 0, message = "Rating cannot be less than 0")
    @Max(value = 5, message = "Rating cannot be more than 5")
    private Integer rating;

    public Review toReview(){
        return Review.builder().comment(this.comment).rating(this.rating).book(Book.builder().bookId(this.bookId).build()).build();
    }
}
