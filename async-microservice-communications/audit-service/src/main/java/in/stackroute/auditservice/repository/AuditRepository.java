package in.stackroute.auditservice.repository;

import in.stackroute.auditservice.domain.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, String>{
}
