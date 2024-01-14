package ru.otus.datajpa.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.datajpa.exception.NotFoundException;
import ru.otus.datajpa.model.Genre;
import ru.otus.datajpa.repository.GenreRepository;
import ru.otus.datajpa.service.GenreService;
import ru.otus.datajpa.utils.ErrorMessage;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Transactional(readOnly = true)
    @Override
    public long getCount() {
        return genreRepository.count();
    }

    @Transactional
    @Override
    public Genre create(String name) {
        var genre = new Genre();
        genre.setName(name);
        return genreRepository.save(genre);
    }

    @Transactional
    @Override
    public Genre update(Genre genreDto) {
        var genre = genreRepository.findById(genreDto.getId())
                .orElseThrow(() ->
                        new NotFoundException(format(ErrorMessage.GENRE_NOT_FOUND, genreDto.getId())));
        genre.setName(genreDto.getName());
        return genre;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Genre> getAll(Sort sort) {
        return genreRepository.findAll(sort);
    }

    @Transactional(readOnly = true)
    @Override
    public Genre getById(long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format(ErrorMessage.GENRE_NOT_FOUND, id)));
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        genreRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        genreRepository.deleteAll();
    }
}