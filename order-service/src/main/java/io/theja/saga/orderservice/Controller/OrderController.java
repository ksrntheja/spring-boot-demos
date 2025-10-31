package io.theja.saga.orderservice.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.theja.saga.orderservice.repo.OrderRepository;
import io.theja.saga.orderservice.repo.Order;

// TODO 12: Add order controller.
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order incoming) {
        incoming.setStatus("CREATED");
        Order saved = repo.save(incoming);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable("id") String id) {
        repo.findById(id).ifPresent(o -> {
            o.setStatus("CANCELLED");
            repo.save(o);
        });
        return ResponseEntity.noContent().build();
    }

}