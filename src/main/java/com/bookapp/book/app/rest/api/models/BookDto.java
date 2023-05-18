package com.bookapp.book.app.rest.api.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class BookDto {


    @NotEmpty
    private String bookName;

    @NotEmpty
    @Size(min = 50 , message = "Summary must be min of 50 words.")
    private String summary;

    @NotEmpty
    private String authorName;
}
