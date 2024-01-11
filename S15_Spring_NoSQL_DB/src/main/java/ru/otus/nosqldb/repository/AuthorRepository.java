package ru.otus.nosqldb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.nosqldb.model.Author;


public interface AuthorRepository extends MongoRepository<Author, String> {

}
