package ru.otus.jpahibernate.repository;

import ru.otus.jpahibernate.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    long count();

    Genre save(Genre genre);

    Optional<Genre> findById(long id);

    List<Genre> findAll();

    void deleteById(long id);

    long deleteAll();
}
