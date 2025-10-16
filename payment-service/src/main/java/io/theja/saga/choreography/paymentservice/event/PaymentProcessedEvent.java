package io.theja.saga.choreography.paymentservice.event;

// TODO 18: Add 'Payment Processed Event' record.
public record PaymentProcessedEvent(
        String orderId,
        String paymentId
) {
}
