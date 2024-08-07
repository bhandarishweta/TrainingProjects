package in.stackroute.helloservice.service;

import in.stackroute.helloservice.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuditMessageService {

    private final AmqpTemplate amqpTemplate;

    public AuditMessageService(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(String message) {
//        log.info("Sending message to audit service: {}", message);
        amqpTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "audit.trail.routingkey", message);
    }
}
