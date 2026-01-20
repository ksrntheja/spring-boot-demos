package io.theja.orderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO 13: Add orders repository.
public interface OrderRepository extends JpaRepository<Order, String> {
}
