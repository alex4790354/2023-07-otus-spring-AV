package ru.otus.securityacl.mapper;

import org.springframework.stereotype.Component;
import ru.otus.securityacl.dto.GenreDto;
import ru.otus.securityacl.model.Genre;


@Component
public class GenreMapper {

    private GenreMapper() {
    }

    public static GenreDto mapGenreToDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }
}

