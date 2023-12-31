package ru.otus.jpahibernate.repository.impl;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.jpahibernate.model.Author;
import ru.otus.jpahibernate.model.Book;
import ru.otus.jpahibernate.model.Genre;
import ru.otus.jpahibernate.repository.BookRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.FETCH;

@Repository
@RequiredArgsConstructor
public class BookRepositoryJpa implements BookRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public long count() {
        return entityManager.createQuery("select count(b) from Book b", Long.class).getSingleResult();
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            entityManager.persist(book);
            return book;
        }
        return entityManager.merge(book);
    }

    @Override
    public Optional<Book> findById(long id) {
        var entityGraph = entityManager.getEntityGraph("genre-author-entity-graph");
        var query = entityManager.createQuery("select b from Book b where b.id = :id", Book.class);
        query.setParameter("id", id);
        query.setHint(FETCH.getKey(), entityGraph);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Book> findAll() {
        var entityGraph = entityManager.getEntityGraph("genre-author-entity-graph");
        var query = entityManager.createQuery("select b from Book b order by b.id", Book.class);
        query.setHint(FETCH.getKey(), entityGraph);
        return query.getResultList();
    }

    @Override
    public List<Book> findAllByGenre(Genre genre) {
        var entityGraph = entityManager.getEntityGraph("genre-author-entity-graph");
        var query = entityManager.createQuery(
                "select b from Book b where b.genre = :genre", Book.class);
        query.setParameter("genre", genre);
        query.setHint(FETCH.getKey(), entityGraph);
        return query.getResultList();
    }

    @Override
    public List<Book> findAllByAuthor(Author author) {
        EntityGraph<?> entityGraph = entityManager.getEntityGraph("genre-author-entity-graph");
        var query = entityManager.createQuery(
                "select b from Book b where b.author = :author", Book.class);
        query.setParameter("author", author);
        query.setHint(FETCH.getKey(), entityGraph);
        return query.getResultList();
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(Book.class, id));
    }

    @Override
    public long deleteAll() {
        return entityManager.createQuery("delete from Book b").executeUpdate();
    }

}
