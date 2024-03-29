package ru.otus.security.service;

import org.springframework.data.domain.Sort;
import ru.otus.security.model.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getAll(Sort sort);
}
