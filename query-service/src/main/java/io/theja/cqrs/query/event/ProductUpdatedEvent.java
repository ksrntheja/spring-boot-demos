package io.theja.cqrs.query.event;

// TODO 9: Add 'Product Updated Event' record.
public record ProductUpdatedEvent(
        String productId,
        double price
) {
}
