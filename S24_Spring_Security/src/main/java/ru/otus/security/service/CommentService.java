package ru.otus.security.service;

import ru.otus.security.model.Comment;

import java.util.List;


public interface CommentService {

    List<Comment> getAllByBookId(long bookId);

}
