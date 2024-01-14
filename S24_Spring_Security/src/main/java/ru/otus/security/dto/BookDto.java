package ru.otus.security.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {

    @NotNull
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private Long genreId;

    @NotNull
    private Long authorId;
}
