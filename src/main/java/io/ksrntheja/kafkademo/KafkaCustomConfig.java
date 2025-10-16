package io.ksrntheja.kafkademo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 TODO 2:
    Idempotence: Creating a NewTopic bean is safe if the topic already exists; Spring will not overwrite existing topic configuration in most cases.
    Else,
    Create a Kafka topic called kafka-topic with 3 partitions and a replication factor of 1.
    The replication factor must be less than or equal to the number of Kafka brokers in the cluster, otherwise topic creation fails.
 */
@Configuration
class KafkaCustomConfig {

    @Bean
    public NewTopic topic() {
        return new NewTopic(
                "kafka-topic",
                3,
                (short) 1);
    }

}
