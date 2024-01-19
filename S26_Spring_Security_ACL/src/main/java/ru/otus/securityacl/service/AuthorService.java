package ru.otus.securityacl.service;

import org.springframework.data.domain.Sort;
import ru.otus.securityacl.dto.AuthorDto;


import java.util.List;

public interface AuthorService {

    List<AuthorDto> getAll(Sort sort);

}
