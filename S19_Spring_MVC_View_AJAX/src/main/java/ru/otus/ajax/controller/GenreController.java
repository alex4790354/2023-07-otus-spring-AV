package ru.otus.ajax.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.ajax.dto.GenreDto;
import ru.otus.ajax.service.GenreService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping(value = "/api/genres")
    public List<GenreDto> handleGetAllGenres() {
        return genreService.getAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
