package ru.otus.securityacl.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.securityacl.dto.GenreDto;
import ru.otus.securityacl.mapper.GenreMapper;
import ru.otus.securityacl.repository.GenreRepository;
import ru.otus.securityacl.service.GenreService;

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
