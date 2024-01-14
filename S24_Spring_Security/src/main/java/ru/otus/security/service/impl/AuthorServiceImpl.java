package ru.otus.security.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.security.model.Author;
import ru.otus.security.repository.AuthorRepository;
import ru.otus.security.service.AuthorService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    @Transactional(readOnly = true)
    @Override
    public List<Author> getAll(Sort sort) {
        return authorRepository.findAll(sort);
    }

}
