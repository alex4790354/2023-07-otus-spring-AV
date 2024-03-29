package ru.otus.webflux.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookCreateDto {

    @NotBlank
    private String title;

    @NotBlank
    private String genreId;

    @NotBlank
    private String authorId;
}
