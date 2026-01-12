package io.theja.cqrs.command.repo;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO 13: Add command repository.
public interface ProductRepository extends JpaRepository<Product, String> {
}
