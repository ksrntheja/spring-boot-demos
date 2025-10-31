package io.theja.saga.paymentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO 17: Add payment repository.
public interface PaymentRepository extends JpaRepository<Payment, String> {
}
