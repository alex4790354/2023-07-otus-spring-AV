package ru.otus.webflux.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.otus.webflux.dto.AuthorDto;
import ru.otus.webflux.mapper.AuthorMapper;
import ru.otus.webflux.repository.AuthorRepository;


@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping(value = "/api/authors")
    public Flux<AuthorDto> handleGetAll() {
        return authorRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                .map(AuthorMapper::mapAuthorToDto);
    }
}
