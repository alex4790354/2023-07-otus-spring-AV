package ru.otus.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.otus.security.model.Author;


public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Modifying
    @Query("delete from Author")
    void deleteAll();
}
