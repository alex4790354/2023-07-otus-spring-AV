package ru.otus.ajax.service;

import ru.otus.ajax.dto.CommentDto;

import java.util.List;


public interface CommentService {

    List<CommentDto> getAllByBookId(long bookId);
}
