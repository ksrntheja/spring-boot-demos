package io.theja.jwtserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.theja.jwtserver.model.User;

// TODO 7:  Add user repository.
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
