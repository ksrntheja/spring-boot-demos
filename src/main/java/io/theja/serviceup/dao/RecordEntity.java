package io.theja.serviceup.dao;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

@Entity
@Table(name = "record")
public class RecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDateTime time;

    @CreationTimestamp(source = SourceType.DB)
    // Automatically sets the created field when the entity is first saved.
    // timestamp to come directly from the database (e.g., for timezone consistency or audit compliance)
    @Column(name = "created", updatable = false)
    // updatable = false: Ensures the timestamp isn’t changed during updates.
    private LocalDateTime created;

    public RecordEntity() {
    }

    public RecordEntity(String id, LocalDateTime time) {
        this.id = id;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}
