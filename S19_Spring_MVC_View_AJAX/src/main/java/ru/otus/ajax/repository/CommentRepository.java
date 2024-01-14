package ru.otus.ajax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ajax.model.Book;
import ru.otus.ajax.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBook(Book book);
}
