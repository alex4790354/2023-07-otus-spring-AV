package ru.otus.webflux.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.webflux.model.Genre;


public interface GenreRepository extends ReactiveMongoRepository<Genre, String> {

}
