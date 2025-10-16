package io.ksrntheja.kafkademo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// TODO 6: Controller
@RestController
class MyController {

    private final KafkaProducerService kafkaProducerService;


    public MyController(
            KafkaProducerService kafkaProducerService
    ) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/demo")
    public ResponseEntity<?> greetUser() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/send/{message}")
    public ResponseEntity<?> sendMessage(@PathVariable String message) {
        kafkaProducerService.sendMessage("my-topic", message);
        return ResponseEntity.ok("Sent message");
    }

    @GetMapping("/send/kafka-topic/{message}")
    public ResponseEntity<?> sendMessageToCustomTopic(@PathVariable String message) {
        kafkaProducerService.sendMessage("kafka-topic", message);
        return ResponseEntity.ok("Sent message");
    }

}
