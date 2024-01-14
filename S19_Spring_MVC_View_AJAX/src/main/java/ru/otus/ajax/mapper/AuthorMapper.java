package ru.otus.ajax.mapper;

import org.springframework.stereotype.Component;
import ru.otus.ajax.dto.AuthorDto;
import ru.otus.ajax.model.Author;

@Component
public class AuthorMapper {

    private AuthorMapper() {
    }

    public static AuthorDto mapAuthorToDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }
}
