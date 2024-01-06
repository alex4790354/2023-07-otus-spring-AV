package ru.otus.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.datajpa.model.Book;
import ru.otus.datajpa.model.Comment;


import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBook(Book book);
}
