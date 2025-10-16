package io.theja.saga.choreography.orderservice.event;

// TODO 7: Add 'Order Created Event' record.
public record OrderCreatedEvent(
        String orderId,
        String product,
        int quantity,
        double amount
) {
}
