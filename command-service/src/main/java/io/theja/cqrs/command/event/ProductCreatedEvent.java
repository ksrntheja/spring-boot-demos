package io.theja.cqrs.command.event;

// TODO 15: Add 'Product Created Event' record.
public record ProductCreatedEvent(
        String productId,
        String name,
        double price
) {
}
