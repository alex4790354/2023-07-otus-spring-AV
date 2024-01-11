package ru.otus.nosqldb.mapper;

import org.springframework.stereotype.Component;
import ru.otus.nosqldb.dto.BookDto;
import ru.otus.nosqldb.model.Author;
import ru.otus.nosqldb.model.Book;
import ru.otus.nosqldb.model.Genre;


@Component
public class BookMapper {

    private BookMapper() {
    }

    public static Book mapDtoToBook(BookDto bookDto, Genre genre, Author author) {

        var bookBuilder = Book.builder();
        bookBuilder.id(bookDto.getId());
        bookBuilder.title(bookDto.getTitle());
        bookBuilder.genre(genre);
        bookBuilder.author(author);

        return bookBuilder.build();
    }
}
