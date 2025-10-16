package io.theja.saga.choreography.orderservice.controller;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.theja.saga.choreography.orderservice.event.OrderCreatedEvent;
import io.theja.saga.choreography.orderservice.repo.Order;
import io.theja.saga.choreography.orderservice.repo.OrderRepository;

// TODO 12: Add Order Controller.
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository repo;
    private final StreamBridge stream;

    public OrderController(
            OrderRepository repo,
            StreamBridge stream
    ) {
        this.repo = repo;
        this.stream = stream;
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order incoming) {
        incoming.setStatus("CREATED");
        Order saved = repo.save(incoming);

        var event = new OrderCreatedEvent(
                saved.getId(), saved.getProduct(),
                saved.getQuantity(), saved.getAmount()
        );
        stream.send("orderCreated-out-0", event);

        System.out.println("Saved in Order DB and Triggered a event!");

        return ResponseEntity.ok(saved);
    }

}
