package com.SchoolManagementSystem.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaProducer kafkaProducerService;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducerService = kafkaProducer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestBody String message) {
        kafkaProducerService.sendMessage(topic, message);
        return "Message sent to Kafka topic!";
    }
}

