package ru.otus.jpahibernate.service;

import ru.otus.jpahibernate.dto.CommentDto;
import ru.otus.jpahibernate.model.Comment;

import java.util.List;


public interface CommentService {

    Comment add(CommentDto commentDto);

    Comment change(CommentDto commentDto);

    Comment getById(long id);

    List<Comment> getAllByBookId(long id);

    void deleteById(long id);
}
