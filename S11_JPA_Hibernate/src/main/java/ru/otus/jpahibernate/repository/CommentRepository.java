package ru.otus.jpahibernate.repository;

import ru.otus.jpahibernate.model.Book;
import ru.otus.jpahibernate.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    Comment save(Comment comment);

    Optional<Comment> findById(long id);

    List<Comment> findAllByBook(Book book);

    void deleteById(long id);
}
