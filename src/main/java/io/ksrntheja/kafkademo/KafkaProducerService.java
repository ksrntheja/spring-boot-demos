package io.ksrntheja.kafkademo;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

// TODO 3: Producer Service
@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducerService(
            KafkaTemplate<String, String> kafkaTemplate
    ) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {

        // Send the message and get a CompletableFuture
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);

        // Use `whenComplete` to handle both success and failure
        future.whenComplete((result, throwable) -> {
            if (throwable != null) {
                // Handle failure
                System.err.println("Error while sending message to " + topic + ": " + throwable.getMessage());
            } else {
                // Handle success
                System.out.println(
                        "Message sent successfully to topic: " + topic +
                                "\nMessage: " + message +
                                "\nPartition: " + result.getRecordMetadata().partition() +
                                "\nOffset: " + result.getRecordMetadata().offset()

                );
            }
        });

    }

}
