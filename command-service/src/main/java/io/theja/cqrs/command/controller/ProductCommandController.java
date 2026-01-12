package io.theja.cqrs.command.controller;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.theja.cqrs.command.event.ProductCreatedEvent;
import io.theja.cqrs.command.event.ProductUpdatedEvent;
import io.theja.cqrs.command.repo.Product;
import io.theja.cqrs.command.repo.ProductRepository;

// TODO 12: Add command controller.
@RestController
@RequestMapping("/commands/products")
public class ProductCommandController {

    private final ProductRepository repo;
    private final StreamBridge stream;

    public ProductCommandController(ProductRepository repo, StreamBridge stream) {
        this.repo = repo;
        this.stream = stream;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product incoming) {
        Product saved = repo.save(incoming);
        var evt = new ProductCreatedEvent(saved.getId(), saved.getName(), saved.getPrice());
        stream.send("productCreated-out-0", evt);
        System.out.println("Saved (new) in Command DB and Triggered a event!");
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updatePrice(
            @PathVariable("id") String id,
            @RequestBody Product payload
    ) {
        return repo.findById(id).map(p -> {
            p.setPrice(payload.getPrice());
            Product updated = repo.save(p);
            var evt = new ProductUpdatedEvent(updated.getId(), updated.getPrice());
            stream.send("productUpdated-out-0", evt);
            System.out.println("Saved (update) in Command DB and Triggered a event!");
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

}
