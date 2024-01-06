package ru.otus.jpahibernate.repository;

import ru.otus.jpahibernate.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    long count();

    Author save(Author author);

    Optional<Author> findById(long id);

    List<Author> findAll();

    void deleteById(long id);

    long deleteAll();
}
