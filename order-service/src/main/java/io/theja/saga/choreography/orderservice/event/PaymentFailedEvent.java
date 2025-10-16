package io.theja.saga.choreography.orderservice.event;

// TODO 8: Add 'Payment Failed Event' record.
public record PaymentFailedEvent(
        String orderId,
        String reason
) {
}
