package ru.otus.mvcview.service;

import org.springframework.data.domain.Sort;
import ru.otus.mvcview.dto.BookCreateDto;
import ru.otus.mvcview.dto.BookDto;
import ru.otus.mvcview.dto.BookUpdateDto;
import ru.otus.mvcview.model.Book;

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
