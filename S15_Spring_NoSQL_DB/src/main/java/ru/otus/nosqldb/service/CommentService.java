package ru.otus.nosqldb.service;

import ru.otus.nosqldb.dto.CommentDto;
import ru.otus.nosqldb.model.Comment;

import java.util.List;


public interface CommentService {

    Comment create(CommentDto commentDto);

    Comment update(CommentDto commentDto);

    Comment getById(String id);

    List<Comment> getAllByBookId(String bookId);

    void deleteById(String id);
}
