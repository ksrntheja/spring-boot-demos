package io.theja.orderquery.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.theja.orderquery.repo.OrderView;
import io.theja.orderquery.repo.OrderViewRepository;

// TODO 5: Add order-query controller.
@RestController
@RequestMapping("/orders")
public class OrderQueryController {

    private final OrderViewRepository repo;

    public OrderQueryController(OrderViewRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<OrderView> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderView> byId(@PathVariable("id") String id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
