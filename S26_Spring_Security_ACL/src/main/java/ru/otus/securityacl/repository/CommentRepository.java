package ru.otus.securityacl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.securityacl.model.Book;
import ru.otus.securityacl.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBook(Book book);
}
