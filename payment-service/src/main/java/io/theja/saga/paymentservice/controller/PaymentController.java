package io.theja.saga.paymentservice.controller;

import io.theja.saga.paymentservice.repo.Payment;
import io.theja.saga.paymentservice.repo.PaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO 16: Add payment controller.
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentRepository repo;

    public PaymentController(PaymentRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<Payment> pay(@RequestBody Payment incoming) {
        // simulate failure for large amounts
        if (incoming.getAmount() > 1000) {
            throw new IllegalArgumentException("Amount exceeds limit, payment refused");
        }
        incoming.setStatus("COMPLETED");
        Payment saved = repo.save(incoming);
        return ResponseEntity.ok(saved);
    }

}
