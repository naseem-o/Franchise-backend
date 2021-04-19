package com.franchise.qa.persistance.repository;

import com.franchise.qa.persistance.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by noravingal on 10/04/21.
 */
@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog,Long> {
}
