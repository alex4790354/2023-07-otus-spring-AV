package ru.otus.webflux.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.otus.webflux.model.Book;



public interface BookRepository extends ReactiveMongoRepository<Book, String> {

    Flux<Book> findAllByGenreId(String genreId);

    Flux<Book> findAllByAuthorId(String authorId);
}
