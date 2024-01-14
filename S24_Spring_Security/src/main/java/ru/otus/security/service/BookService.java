package ru.otus.security.service;

import org.springframework.data.domain.Sort;
import ru.otus.security.dto.BookCreateDto;
import ru.otus.security.dto.BookDto;
import ru.otus.security.dto.BookUpdateDto;
import ru.otus.security.model.Book;

import java.util.List;

public interface BookService {

    BookDto create(BookCreateDto bookCreateDto);

    Book update(BookUpdateDto bookUpdateDto);

    List<Book> getAll(Sort sort);

    Book getById(long id);

    List<Book> getAllByGenreId(long genreId);

    List<Book> getAllByAuthorId(long authorId);

    void deleteById(long id);

    void deleteAll();

}
