package ru.otus.securityacl.mapper;

import org.springframework.stereotype.Component;
import ru.otus.securityacl.dto.AuthorDto;
import ru.otus.securityacl.model.Author;

@Component
public class AuthorMapper {

    private AuthorMapper() {
    }

    public static AuthorDto mapAuthorToDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }
}
