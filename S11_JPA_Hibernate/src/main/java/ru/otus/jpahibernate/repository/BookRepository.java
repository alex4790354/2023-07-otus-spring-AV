package ru.otus.jpahibernate.repository;

import ru.otus.jpahibernate.model.Author;
import ru.otus.jpahibernate.model.Book;
import ru.otus.jpahibernate.model.Genre;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    long count();

    Book save(Book book);

    Optional<Book> findById(long id);

    List<Book> findAll();

    List<Book> findAllByGenre(Genre genre);

    List<Book> findAllByAuthor(Author author);

    void deleteById(long id);

    long deleteAll();
}
