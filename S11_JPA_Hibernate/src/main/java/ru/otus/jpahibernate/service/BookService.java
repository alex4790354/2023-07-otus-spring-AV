package ru.otus.jpahibernate.service;

import ru.otus.jpahibernate.dto.BookDto;
import ru.otus.jpahibernate.model.Book;

import java.util.List;

public interface BookService {
    long getCount();

    Book add(BookDto bookDto);

    Book change(BookDto bookDto);

    List<Book> getAll();

    Book getById(long id);

    List<Book> getAllByGenreId(long id);

    List<Book> getAllByAuthorId(long id);

    void deleteById(long id);

    long deleteAll();

}
