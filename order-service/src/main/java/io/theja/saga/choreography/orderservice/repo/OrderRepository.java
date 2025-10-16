package io.theja.saga.choreography.orderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO 6: Add Order Repository.
public interface OrderRepository extends JpaRepository<Order, String> {
}
