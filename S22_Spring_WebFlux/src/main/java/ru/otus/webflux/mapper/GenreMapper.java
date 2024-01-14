package ru.otus.webflux.mapper;

import org.springframework.stereotype.Component;
import ru.otus.webflux.dto.GenreDto;
import ru.otus.webflux.model.Genre;


@Component
public class GenreMapper {

    private GenreMapper() {
    }

    public static GenreDto mapGenreToDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }
}

