package ru.otus.ajax.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ajax.dto.GenreDto;
import ru.otus.ajax.mapper.GenreMapper;
import ru.otus.ajax.repository.GenreRepository;
import ru.otus.ajax.service.GenreService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Transactional(readOnly = true)
    @Override
    public List<GenreDto> getAll(Sort sort) {
        return genreRepository.findAll(sort)
                .stream()
                .map(GenreMapper::mapGenreToDto)
                .toList();
    }

}
