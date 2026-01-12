package io.theja.cqrs.query.repo;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO 6: Add query repository.
public interface ProductViewRepository extends JpaRepository<ProductView, String> {
}
