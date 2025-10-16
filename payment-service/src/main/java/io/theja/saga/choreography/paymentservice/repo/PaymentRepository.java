package io.theja.saga.choreography.paymentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO 15: Add Payment Repository.
public interface PaymentRepository extends JpaRepository<Payment, String> {
}
