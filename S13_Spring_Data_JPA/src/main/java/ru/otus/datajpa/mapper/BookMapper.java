package ru.otus.datajpa.mapper;

import org.springframework.stereotype.Component;
import ru.otus.datajpa.dto.BookDto;
import ru.otus.datajpa.model.Author;
import ru.otus.datajpa.model.Book;
import ru.otus.datajpa.model.Genre;


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
