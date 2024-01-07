package ru.otus.mvcview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.mvcview.model.Book;
import ru.otus.mvcview.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBook(Book book);
}
