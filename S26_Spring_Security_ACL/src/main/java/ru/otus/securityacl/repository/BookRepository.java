package ru.otus.securityacl.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.otus.securityacl.model.Book;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {

    @EntityGraph(value = "genre-author-entity-graph")
    Optional<Book> findById(long id);

    @EntityGraph(value = "genre-author-entity-graph")
    List<Book> findAll();

    @EntityGraph(attributePaths = {"author"})
    List<Book> findAllByGenreId(long id);

    @EntityGraph(attributePaths = {"genre"})
    List<Book> findAllByAuthorId(long id);

    @Modifying
    @Query("delete from Book")
    void deleteAll();
}
