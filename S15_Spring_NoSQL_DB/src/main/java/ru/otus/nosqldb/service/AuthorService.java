package ru.otus.nosqldb.service;

import org.springframework.data.domain.Sort;
import ru.otus.nosqldb.model.Author;

import java.util.List;

public interface AuthorService {
    long getCount();

    Author create(String name);

    Author update(Author authorDto);

    Author getById(String id);

    List<Author> getAll(Sort sort);

    void deleteById(String id);

    void deleteAll();
}
