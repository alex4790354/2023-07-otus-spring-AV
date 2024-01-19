package ru.otus.batch.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.otus.batch.model.jpa.Author;
import ru.otus.batch.model.mongo.AuthorDocument;

@Service
public class AuthorConverter implements Converter<Author, AuthorDocument> {

    @Override
    public AuthorDocument convert(Author author) {
        return new AuthorDocument(String.valueOf(author.getId()),author.getName());
    }
}
