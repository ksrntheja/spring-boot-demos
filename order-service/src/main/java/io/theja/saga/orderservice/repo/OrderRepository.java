package io.theja.saga.orderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO 13: Add order repository.
public interface OrderRepository extends JpaRepository<Order, String> {
}
