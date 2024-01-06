package ru.otus.datajpa.service;

import org.springframework.data.domain.Sort;
import ru.otus.datajpa.model.Genre;

import java.util.List;

public interface GenreService {
    long getCount();

    Genre create(String name);

    Genre update(Genre genreDto);

    List<Genre> getAll(Sort sort);

    Genre getById(long id);

    void deleteById(long id);

    void deleteAll();
}
