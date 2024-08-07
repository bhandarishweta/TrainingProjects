package in.stackroute.helloservice.controller;

import in.stackroute.helloservice.dto.Request;
import in.stackroute.helloservice.service.AuditMessageService;
import in.stackroute.helloservice.service.TrailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    private final TrailService trailService;
    private final AuditMessageService auditMessageService;

    public HelloController(TrailService trailService, AuditMessageService auditMessageService) {
        this.trailService = trailService;
        this.auditMessageService = auditMessageService;
    }

    @PostMapping
    public String trail(@RequestBody Request request) {
        // perform some action
//        trailService.sendAudit(request.auditMessage()); // raise an audit trail
        auditMessageService.sendMessage(request.auditMessage()); // send a message to audit service
        return "Done!";
    }
}
