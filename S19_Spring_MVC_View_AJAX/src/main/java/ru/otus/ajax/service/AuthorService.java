package ru.otus.ajax.service;

import org.springframework.data.domain.Sort;
import ru.otus.ajax.dto.AuthorDto;


import java.util.List;

public interface AuthorService {

    List<AuthorDto> getAll(Sort sort);

}
