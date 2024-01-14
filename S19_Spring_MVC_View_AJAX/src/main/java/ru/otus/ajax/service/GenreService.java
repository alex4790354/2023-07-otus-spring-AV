package ru.otus.ajax.service;

import org.springframework.data.domain.Sort;
import ru.otus.ajax.dto.GenreDto;


import java.util.List;

public interface GenreService {

    List<GenreDto> getAll(Sort sort);

}
