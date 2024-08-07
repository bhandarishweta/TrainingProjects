package in.stackroute.auditservice.service;

import in.stackroute.auditservice.domain.Audit;
import in.stackroute.auditservice.repository.AuditRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService {

    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public Audit saveAudit(String auditMessage) {
        Audit audit = new Audit();
        audit.setAuditMessage(auditMessage);
        return auditRepository.save(audit);
    }

    public List<Audit> getAllAudits() {
        return auditRepository.findAll();
    }
}
