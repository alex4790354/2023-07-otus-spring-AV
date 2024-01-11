package ru.otus.nosqldb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.nosqldb.model.Comment;


import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findAllByBookId(String id);
}
