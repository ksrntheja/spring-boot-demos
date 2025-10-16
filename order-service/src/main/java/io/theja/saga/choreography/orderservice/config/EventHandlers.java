package io.theja.saga.choreography.orderservice.config;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.theja.saga.choreography.orderservice.event.PaymentFailedEvent;
import io.theja.saga.choreography.orderservice.event.PaymentProcessedEvent;
import io.theja.saga.choreography.orderservice.repo.OrderRepository;

// TODO 11: Add Event Handlers.
@Component
public class EventHandlers {

    private final OrderRepository repo;

    public EventHandlers(OrderRepository repo) {
        this.repo = repo;
    }

    @Bean
    public Consumer<PaymentProcessedEvent> paymentProcessed() {
        return evt -> repo.findById(evt.orderId()).ifPresent(o -> {
            o.setStatus("COMPLETED");
            repo.save(o);
            System.out.println("Saved in Order DB as COMPLETED!");
        });
    }

    @Bean
    public Consumer<PaymentFailedEvent> paymentFailed() {
        return evt -> repo.findById(evt.orderId()).ifPresent(o -> {
            o.setStatus("CANCELLED");
            repo.save(o);
            System.out.println("Saved in Order DB as CANCELLED!");
        });
    }

}
