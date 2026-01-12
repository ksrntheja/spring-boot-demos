package io.theja.cqrs.query.event;

// TODO 8: Add 'Product Created Event' record.
public record ProductCreatedEvent(
        String productId,
        String name,
        double price
) {
}
