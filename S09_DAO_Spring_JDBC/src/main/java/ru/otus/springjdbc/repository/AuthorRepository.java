package ru.otus.springjdbc.repository;

import ru.otus.springjdbc.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    long count();

    Author insert(Author author);

    void update(Author author);

    Optional<Author> findById(long id);

    List<Author> findAll();

    void deleteById(long id);

    long deleteAll();
}
