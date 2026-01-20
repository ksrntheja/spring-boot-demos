package io.theja.orderservice.config;

import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import io.theja.orderservice.repo.OutboxEvent;
import io.theja.orderservice.repo.OutboxEventRepository;

// TODO 16: Add order-events publisher - Publish event & set outbox_events setPublished(true).
@Component
public class OutboxEventPublisher {

    private final OutboxEventRepository outboxRepo;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public OutboxEventPublisher(
            OutboxEventRepository outboxRepo,
            KafkaTemplate<String, String> kafkaTemplate
    ) {
        this.outboxRepo = outboxRepo;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedDelayString = "5000")
    public void publishEvents() {
        List<OutboxEvent> events = outboxRepo.findByPublishedFalse();
        for (OutboxEvent evt : events) {
            kafkaTemplate.send("order-events", evt.getAggregateId(), evt.getPayload());
            evt.setPublished(true);
            outboxRepo.save(evt);
            System.out.println("Triggered order-event!");
        }
    }

}
