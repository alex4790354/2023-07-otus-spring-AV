package ru.otus.springjdbc.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.springjdbc.dto.BookDto;
import ru.otus.springjdbc.model.Author;
import ru.otus.springjdbc.model.Book;
import ru.otus.springjdbc.model.Genre;

@Component
@NoArgsConstructor
public class BookMapper {

    public static Book mapDtoToBook(BookDto bookDto, Genre genre, Author author) {

        var bookBuilder = Book.builder();
        bookBuilder.id(bookDto.getId());
        bookBuilder.title(bookDto.getTitle());
        bookBuilder.genre(genre);
        bookBuilder.author(author);

        return bookBuilder.build();
    }
}
