package ru.otus.webflux.mapper;

import org.springframework.stereotype.Component;
import ru.otus.webflux.dto.AuthorDto;
import ru.otus.webflux.model.Author;

@Component
public class AuthorMapper {

    private AuthorMapper() {
    }

    public static AuthorDto mapAuthorToDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }
}
