package ru.otus.securityacl.mapper;

import org.springframework.stereotype.Component;
import ru.otus.securityacl.dto.BookCreateDto;
import ru.otus.securityacl.dto.BookDto;
import ru.otus.securityacl.model.Author;
import ru.otus.securityacl.model.Book;
import ru.otus.securityacl.model.Genre;


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
        bookDto.setAuthor(book.getAuthor().getName());
        bookDto.setGenre(book.getGenre().getName());

        return bookDto;
    }

}
