package io.theja.cqrs.query.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.theja.cqrs.query.repo.ProductView;
import io.theja.cqrs.query.repo.ProductViewRepository;
import org.springframework.http.ResponseEntity;

// TODO 5: Add query controller.
@RestController
@RequestMapping("/queries/products")
public class ProductQueryController {

    private final ProductViewRepository repo;

    public ProductQueryController(ProductViewRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<ProductView> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductView> byId(@PathVariable String id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
