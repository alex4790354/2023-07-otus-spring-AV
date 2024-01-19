package ru.otus.securityacl.service;

import ru.otus.securityacl.dto.CommentDto;

import java.util.List;


public interface CommentService {

    List<CommentDto> getAllByBookId(long bookId);
}
