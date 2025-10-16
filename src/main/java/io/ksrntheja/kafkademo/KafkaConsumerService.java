package io.ksrntheja.kafkademo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

// TODO 4: Create 1 consumer for 'my-topic' and 4 consumers for 'kafka-topic'
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "my-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(ConsumerRecord<String, String> record) {
//    , Acknowledgment ack) {
        try {
            String key = record.key();
            String message = record.value();
            System.out.println("Received message: " + message + " with key: " + key);
            // Process the message based on business logic
//            Thread.sleep(50000); // 50 seconds
//            ack.acknowledge(); // Manually commit offset when processing is successful
        } catch (Exception e) {
            // In production, log the error and consider sending the message to a dead-letter topic
            System.err.println("Failed to process message: " + e.getMessage());
        }
    }

    @KafkaListener(topics = "kafka-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void listenKafkaTopicC1(String message) {
        try {
            System.out.println("Received message C1: " + message);
        } catch (Exception e) {
            System.err.println("Failed to process message C1: " + e.getMessage());
        }
    }

    @KafkaListener(topics = "kafka-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void listenKafkaTopicC2(String message) {

        try {
            System.out.println("Received message C2: " + message);
        } catch (Exception e) {
            System.err.println("Failed to process message C2: " + e.getMessage());
        }
    }

    @KafkaListener(topics = "kafka-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void listenKafkaTopicC3(String message) {

        try {
            System.out.println("Received message C3: " + message);
        } catch (Exception e) {
            System.err.println("Failed to process message  C3: " + e.getMessage());
        }
    }

    @KafkaListener(topics = "kafka-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void listenKafkaTopicC4(String message) {

        try {
            System.out.println("Received message C4: " + message);
        } catch (Exception e) {
            System.err.println("Failed to process message C4: " + e.getMessage());
        }
    }

}
