package ru.otus.securityacl.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.securityacl.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
