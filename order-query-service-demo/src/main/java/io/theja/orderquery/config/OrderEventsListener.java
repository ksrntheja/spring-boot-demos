package io.theja.orderquery.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import io.theja.orderquery.repo.OrderView;
import io.theja.orderquery.repo.OrderViewRepository;

// TODO 8: Add order-events listener - Save to order_view table.
@Component
public class OrderEventsListener {

    private final OrderViewRepository repo;
    private final ObjectMapper mapper;

    public OrderEventsListener(
            OrderViewRepository repo,
            ObjectMapper mapper
    ) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @KafkaListener(topics = "order-events", groupId = "order-query-group")
    public void onOrderEvent(ConsumerRecord<String, String> record) {
        try {
            OrderView view = mapper.readValue(record.value(), OrderView.class);
            repo.save(view);
            System.out.println("Saved in OrderView DB - Order!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
