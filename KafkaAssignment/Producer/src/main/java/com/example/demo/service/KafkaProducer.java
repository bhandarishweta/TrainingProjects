package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Notification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaProducer {
private Logger log = LoggerFactory.getLogger(KafkaProducer.class);
	
    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessage(Notification notification) throws JsonProcessingException {
        
    	String orderAsMessage = objectMapper.writeValueAsString(notification);
        
    	kafkaTemplate.send(orderTopic, orderAsMessage);

        log.info("notification object produced {}", orderAsMessage);

        return "Message Sent From Producer.";
    }


}
