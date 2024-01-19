package ru.otus.securityacl.service;

import org.springframework.data.domain.Sort;
import ru.otus.securityacl.dto.GenreDto;


import java.util.List;

public interface GenreService {

    List<GenreDto> getAll(Sort sort);

}
