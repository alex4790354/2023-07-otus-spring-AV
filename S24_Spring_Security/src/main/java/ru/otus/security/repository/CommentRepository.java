package ru.otus.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.security.model.Book;
import ru.otus.security.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBook(Book book);
}
