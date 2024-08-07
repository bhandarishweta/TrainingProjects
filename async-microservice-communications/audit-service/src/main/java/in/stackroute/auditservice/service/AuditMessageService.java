package in.stackroute.auditservice.service;

import in.stackroute.auditservice.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuditMessageService {

    private final AuditService auditService;

    public AuditMessageService(AuditService auditService) {
        this.auditService = auditService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void readMessage(String message) {
        log.info("Reading from the queue: {}" , message);
        auditService.saveAudit(message);
    }
}
