package ru.otus.mvcview.service;

import ru.otus.mvcview.dto.CommentCreateDto;
import ru.otus.mvcview.dto.CommentDto;
import ru.otus.mvcview.model.Comment;

import java.util.List;


public interface CommentService {

    CommentDto create(CommentCreateDto commentCreateDto);

    Comment update(CommentDto commentDto);

    Comment getById(long id);

    List<Comment> getAllByBookId(long bookId);

    void deleteById(long id);
}
