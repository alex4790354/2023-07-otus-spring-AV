package ru.otus.securityacl.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.securityacl.dto.AuthorDto;
import ru.otus.securityacl.mapper.AuthorMapper;
import ru.otus.securityacl.repository.AuthorRepository;
import ru.otus.securityacl.service.AuthorService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    @Transactional(readOnly = true)
    @Override
    public List<AuthorDto> getAll(Sort sort) {
        return authorRepository.findAll(sort)
                .stream()
                .map(AuthorMapper::mapAuthorToDto)
                .toList();
    }

}
