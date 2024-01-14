package ru.otus.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.otus.webflux.model.Book;
import ru.otus.webflux.model.Comment;




public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {

    Flux<Comment> findAllByBook(Book book);
}
