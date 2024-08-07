package in.stackroute.helloservice.dto;

import java.time.LocalDateTime;

public record AuditDto(String id, String auditMessage, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
}
