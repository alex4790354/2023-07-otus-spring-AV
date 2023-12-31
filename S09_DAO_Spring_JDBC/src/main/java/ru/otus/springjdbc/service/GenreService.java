package ru.otus.springjdbc.service;

import ru.otus.springjdbc.model.Genre;

import java.util.List;

public interface GenreService {
    long getCount();

    Genre add(String genreName);

    void change(Genre genreDto);

    List<Genre> getAll();

    void deleteById(long id);

    long deleteAll();
}
