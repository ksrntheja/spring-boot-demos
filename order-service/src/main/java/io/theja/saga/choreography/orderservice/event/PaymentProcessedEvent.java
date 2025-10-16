package io.theja.saga.choreography.orderservice.event;

// TODO 9: Add 'Payment Processed Event' record.
public record PaymentProcessedEvent(
        String orderId,
        String paymentId
) {
}
