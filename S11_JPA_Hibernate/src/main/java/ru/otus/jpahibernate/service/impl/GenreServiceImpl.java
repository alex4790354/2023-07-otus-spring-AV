package ru.otus.jpahibernate.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.jpahibernate.exception.NotFoundException;
import ru.otus.jpahibernate.model.Genre;
import ru.otus.jpahibernate.repository.GenreRepository;
import ru.otus.jpahibernate.service.GenreService;

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
    public Genre add(String name) {
        var genre = new Genre();
        genre.setName(name);
        return genreRepository.save(genre);
    }

    @Transactional
    @Override
    public Genre change(Genre genreDto) {
        var genre = genreRepository.findById(genreDto.getId())
                .orElseThrow(() ->
                        new NotFoundException(format("Не найден жанр с идентификатором %d", genreDto.getId())));
        genre.setName(genreDto.getName());
        return genre;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Genre getById(long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format("Не найден жанр с идентификатором %d", id)));
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        genreRepository.deleteById(id);
    }

    @Transactional
    @Override
    public long deleteAll() {
        return genreRepository.deleteAll();
    }
}
