package ru.otus.ajax.mapper;

import org.springframework.stereotype.Component;
import ru.otus.ajax.dto.GenreDto;
import ru.otus.ajax.model.Genre;


@Component
public class GenreMapper {

    private GenreMapper() {
    }

    public static GenreDto mapGenreToDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }
}

