package ru.otus.security.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.security.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
