package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Notification;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class ProducerService {
	
	private final KafkaProducer producer;

    @Autowired
    public ProducerService(KafkaProducer producer) {
        this.producer = producer;
    }

    public String createNotification(Notification notification) throws JsonProcessingException {
        return producer.sendMessage(notification);
    }

	
	
}
