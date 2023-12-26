package ru.geekbrains.market.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.market.auth.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
