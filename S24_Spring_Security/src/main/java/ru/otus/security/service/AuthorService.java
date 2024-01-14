package ru.otus.security.service;

import org.springframework.data.domain.Sort;
import ru.otus.security.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAll(Sort sort);
}
