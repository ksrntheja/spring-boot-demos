package io.theja.orderservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO 15: Add outbox_events repository.
public interface OutboxEventRepository extends JpaRepository<OutboxEvent, String> {
    List<OutboxEvent> findByPublishedFalse();
}
