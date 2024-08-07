package in.stackroute.helloservice.service;

import in.stackroute.helloservice.dto.AuditDto;
import in.stackroute.helloservice.dto.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@EnableAsync
@Slf4j
public class TrailService {

    private final WebClient webClient;

    public TrailService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Async
    public void sendAudit(String message) {
        Request request = new Request(message);
        final String AUDIT_SERVICE_URL = "http://localhost:8080/api/v1/audits";
        AuditDto response = webClient.post()
                .uri(AUDIT_SERVICE_URL)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(AuditDto.class)
                .block();
        log.info("Response from audit-service: {}", response);
    }
}
