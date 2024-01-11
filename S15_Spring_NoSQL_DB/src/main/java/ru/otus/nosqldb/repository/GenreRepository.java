package ru.otus.nosqldb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.nosqldb.model.Genre;


public interface GenreRepository extends MongoRepository<Genre, String> {

}
