package com.example.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.consumer.domain.Notification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaConsumer {
	private Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;
    //private final ConsumerService consumerService;

    @Autowired
    public KafkaConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
      //  this.consumerService = consumerService;
    }

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        
        Notification notification = objectMapper.readValue(message, Notification.class);
        System.out.println("notification  object : "+notification);
        
        //consumerService.persistNotification(notificationDto);
    }


}
