package io.theja.orderservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.theja.orderservice.repo.Order;
import io.theja.orderservice.repo.OrderRepository;
import io.theja.orderservice.repo.OutboxEvent;
import io.theja.orderservice.repo.OutboxEventRepository;

// TODO 11: Add order service - save to orders & outbox_events (setPublished(false)) tables.
@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final OutboxEventRepository outboxRepo;
    private final ObjectMapper mapper;

    public OrderService(
            OrderRepository orderRepo,
            OutboxEventRepository outboxRepo,
            ObjectMapper mapper
    ) {
        this.orderRepo = orderRepo;
        this.outboxRepo = outboxRepo;
        this.mapper = mapper;
    }

    @Transactional
    public Order createOrder(Order order) {
        order.setStatus("CREATED");
        Order saved = orderRepo.save(order);
        System.out.println("Saved in Order DB - Order!");

        try {
            OutboxEvent event = new OutboxEvent();
            event.setAggregateType("Order");
            event.setAggregateId(saved.getId());
            event.setEventType("OrderCreated");
            event.setPayload(mapper.writeValueAsString(saved));
            event.setPublished(false);
            outboxRepo.save(event);
            System.out.println("Saved in Order DB - OrderEvent!");
        } catch (Exception e) {
            throw new RuntimeException("Failed to persist outbox event", e);
        }

        return saved;
    }

}
