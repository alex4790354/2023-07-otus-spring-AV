package ru.otus.nosqldb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.otus.nosqldb.exception.NotFoundException;
import ru.otus.nosqldb.model.Genre;
import ru.otus.nosqldb.repository.GenreRepository;
import ru.otus.nosqldb.service.GenreService;
import ru.otus.nosqldb.utils.ErrorMessage;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public long getCount() {
        return genreRepository.count();
    }

    @Override
    public Genre create(String name) {
        var genre = new Genre();
        genre.setName(name);
        return genreRepository.save(genre);
    }

    @Override
    public Genre update(Genre genreDto) {
        var genre = genreRepository.findById(genreDto.getId())
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorMessage.GENRE_NOT_FOUND, genreDto.getId())));
        genre.setName(genreDto.getName());
        return genre;
    }

    @Override
    public List<Genre> getAll(Sort sort) {
        return genreRepository.findAll(sort);
    }

    @Override
    public Genre getById(String id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format(ErrorMessage.GENRE_NOT_FOUND, id)));
    }

    @Override
    public void deleteById(String id) {
        genreRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        genreRepository.deleteAll();
    }
}
