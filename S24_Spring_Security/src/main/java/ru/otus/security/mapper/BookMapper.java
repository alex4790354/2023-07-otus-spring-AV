package ru.otus.security.mapper;


import org.springframework.stereotype.Component;
import ru.otus.security.dto.BookCreateDto;
import ru.otus.security.dto.BookDto;
import ru.otus.security.model.Author;
import ru.otus.security.model.Book;
import ru.otus.security.model.Genre;


@Component
public class BookMapper {

    private BookMapper() {
    }

    public static Book mapDtoToNewBook(BookCreateDto bookCreateDto, Genre genre, Author author) {

        var bookBuilder = Book.builder();
        bookBuilder.title(bookCreateDto.getTitle());
        bookBuilder.genre(genre);
        bookBuilder.author(author);

        return bookBuilder.build();
    }

    public static BookDto mapBookToDto(Book book) {

        var bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthorId(book.getAuthor().getId());
        bookDto.setGenreId(book.getGenre().getId());

        return bookDto;
    }
}
