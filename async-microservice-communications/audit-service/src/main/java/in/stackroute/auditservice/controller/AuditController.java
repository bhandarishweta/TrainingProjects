package in.stackroute.auditservice.controller;

import in.stackroute.auditservice.domain.Audit;
import in.stackroute.auditservice.dto.AuditDto;
import in.stackroute.auditservice.dto.AuditRequest;
import in.stackroute.auditservice.service.AuditService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/audits")
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    // Add a method to save audit
    @PostMapping
    public ResponseEntity<AuditDto> saveAudit(@RequestBody AuditRequest request) {
        Audit audit = auditService.saveAudit(request.auditMessage());
        AuditDto response = convertToDto(audit);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Add a method to get all audits
    @GetMapping
    public ResponseEntity<List<AuditDto>> getAllAudits() {
        return ResponseEntity.ok(auditService.getAllAudits().stream().map(this::convertToDto).toList());
    }

    private AuditDto convertToDto(Audit audit) {
        return new AuditDto(audit.getId(), audit.getAuditMessage(), audit.getCreatedDate(), audit.getLastModifiedDate());
    }
}
