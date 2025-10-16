package io.theja.saga.choreography.paymentservice.event;

// TODO 17: Add 'Payment Failed Event' record.
public record PaymentFailedEvent(
        String orderId,
        String reason
) {
}
