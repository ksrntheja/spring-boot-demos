package io.theja.cqrs.query.config;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.theja.cqrs.query.event.ProductCreatedEvent;
import io.theja.cqrs.query.event.ProductUpdatedEvent;
import io.theja.cqrs.query.repo.ProductView;
import io.theja.cqrs.query.repo.ProductViewRepository;

// TODO 10: Add Event Handlers.
@Component
public class ProductEventHandlers {

    private final ProductViewRepository repo;

    public ProductEventHandlers(ProductViewRepository repo) {
        this.repo = repo;
    }

    @Bean
    public Consumer<ProductCreatedEvent> productCreated() {
        return evt -> {
            var view = new ProductView();
            view.setId(evt.productId());
            view.setName(evt.name());
            view.setPrice(evt.price());
            repo.save(view);
            System.out.println("Saved (new) in Query DB!");
        };
    }

    @Bean
    public Consumer<ProductUpdatedEvent> productUpdated() {
        return evt -> repo.findById(evt.productId()).ifPresent(view -> {
            view.setPrice(evt.price());
            repo.save(view);
            System.out.println("Saved (update) in Query DB!");
        });
    }

}
