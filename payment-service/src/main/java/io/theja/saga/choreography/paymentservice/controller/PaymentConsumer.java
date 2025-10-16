package io.theja.saga.choreography.paymentservice.controller;

import java.util.function.Consumer;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.theja.saga.choreography.paymentservice.event.OrderCreatedEvent;
import io.theja.saga.choreography.paymentservice.event.PaymentFailedEvent;
import io.theja.saga.choreography.paymentservice.event.PaymentProcessedEvent;
import io.theja.saga.choreography.paymentservice.repo.Payment;
import io.theja.saga.choreography.paymentservice.repo.PaymentRepository;

// TODO 19: Add Payment Consumer.
@Component
public class PaymentConsumer {

    private final PaymentRepository repo;
    private final StreamBridge stream;

    public PaymentConsumer(
            PaymentRepository repo,
            StreamBridge stream
    ) {
        this.repo = repo;
        this.stream = stream;
    }

    @Bean
    public Consumer<OrderCreatedEvent> processOrder() {
        return evt -> {
            // simulate business rule
            if (evt.amount() > 1000) {
                var fail = new PaymentFailedEvent(evt.orderId(), "Amount exceeds limit");
                stream.send("paymentFailed-out-0", fail);
                System.out.println("Triggered a PaymentFailed event!");
            } else {
                var payment = new Payment();
                payment.setOrderId(evt.orderId());
                payment.setAmount(evt.amount());
                payment.setStatus("COMPLETED");
                var saved = repo.save(payment);

                var success = new PaymentProcessedEvent(saved.getOrderId(), saved.getPaymentId());
                stream.send("paymentProcessed-out-0", success);
                System.out.println("Saved in Payment DB and Triggered a event!");
            }
        };
    }

}
