package io.theja.saga.choreography.paymentservice.event;

// TODO 16: Add 'Order Created Event' record.
public record OrderCreatedEvent(
        String orderId,
        String product,
        int quantity,
        double amount
) {
}
