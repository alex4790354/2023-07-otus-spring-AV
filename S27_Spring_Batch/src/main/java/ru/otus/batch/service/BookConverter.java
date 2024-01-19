package ru.otus.batch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.otus.batch.model.jpa.Author;
import ru.otus.batch.model.jpa.Book;
import ru.otus.batch.model.jpa.Genre;
import ru.otus.batch.model.mongo.AuthorDocument;
import ru.otus.batch.model.mongo.BookDocument;
import ru.otus.batch.model.mongo.GenreDocument;

@Service
@RequiredArgsConstructor
public class BookConverter implements Converter<Book, BookDocument> {

    private final Converter<Author, AuthorDocument> authorConverter;

    private final Converter<Genre, GenreDocument> genreConverter;


    @Override
    public BookDocument convert(Book book) {
        var genre = book.getGenre();
        var author = book.getAuthor();
        return new BookDocument(String.valueOf(book.getId()),
                        book.getTitle(),
                genreConverter.convert(genre),
                authorConverter.convert(author));
    }
}
