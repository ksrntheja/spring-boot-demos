package io.theja.cqrs.command.event;

// TODO 16: Add 'Product Updated Event' record.
public record ProductUpdatedEvent(
        String productId,
        double price
) {
}
