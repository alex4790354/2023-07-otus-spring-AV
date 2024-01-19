package ru.otus.batch.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.otus.batch.model.jpa.Genre;
import ru.otus.batch.model.mongo.GenreDocument;

@Service
public class GenreConverter implements Converter<Genre, GenreDocument> {

    @Override
    public GenreDocument convert(Genre genre) {
        return new GenreDocument(String.valueOf(genre.getId()), genre.getName());
    }
}
