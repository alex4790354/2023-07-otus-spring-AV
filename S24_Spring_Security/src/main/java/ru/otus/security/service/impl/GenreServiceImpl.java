package ru.otus.security.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.security.model.Genre;
import ru.otus.security.repository.GenreRepository;
import ru.otus.security.service.GenreService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;


    @Transactional(readOnly = true)
    @Override
    public List<Genre> getAll(Sort sort) {
        return genreRepository.findAll(sort);
    }
}
