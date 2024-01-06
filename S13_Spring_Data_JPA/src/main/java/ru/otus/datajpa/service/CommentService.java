package ru.otus.datajpa.service;

import ru.otus.datajpa.dto.CommentDto;
import ru.otus.datajpa.model.Comment;

import java.util.List;


public interface CommentService {

    Comment create(CommentDto commentDto);

    Comment update(CommentDto commentDto);

    Comment getById(long id);

    List<Comment> getAllByBookId(long id);

    void deleteById(long id);
}
