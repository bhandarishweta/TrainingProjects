package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Notification;
import com.example.demo.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;


@RestController
@RequestMapping("/notification")
public class ProducerController {

	
private Logger log = LoggerFactory.getLogger(ProducerController.class);
	
    private final ProducerService producerService;

    //@Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public String createFoodOrder(@RequestBody Notification notification) throws JsonProcessingException {
        log.info("create food order request received");
        return producerService.createNotification(notification);
    }

}
