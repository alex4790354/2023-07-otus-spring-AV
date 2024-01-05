package ru.otus.springjdbc.service;

import ru.otus.springjdbc.model.Author;

import java.util.List;

public interface AuthorService {
    long getCount();

    Author add(String authorName);

    void change(Author authorDto);

    List<Author> getAll();

    void deleteById(long id);

    long deleteAll();
}
