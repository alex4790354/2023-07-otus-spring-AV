package ru.otus.ajax.service;

import org.springframework.data.domain.Sort;
import ru.otus.ajax.dto.BookCreateDto;
import ru.otus.ajax.dto.BookDto;
import ru.otus.ajax.dto.BookUpdateDto;

import java.util.List;

public interface BookService {

    BookDto create(BookCreateDto bookCreateDto);

    BookDto update(BookUpdateDto bookUpdateDto);

    List<BookDto> getAll(Sort sort);

    BookDto getById(long id);

    List<BookDto> getAllByGenreId(long genreId);

    List<BookDto> getAllByAuthorId(long authorId);

    void deleteById(long id);

    void deleteAll();

}
