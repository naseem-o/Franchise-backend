package com.franchise.qa.auditlog;

import com.franchise.qa.persistance.entity.AuditLog;
import com.franchise.qa.persistance.repository.AuditLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;




 /*Created by noravingal on 09/04/21*/


@Component
public class AuditLogEventHandler {
    @Autowired
    private AuditLogRepository auditLogRepository;

    private static final Logger logger = LoggerFactory.getLogger(AuditLogEventHandler.class);
    private final ApplicationEventPublisher publisher;

    public AuditLogEventHandler(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Async
    @EventListener
    public void auditLogEventListener(AuditLog auditLog) {

        if(auditLog != null){
            logger.info("Received user activity and saving to the database: {}", auditLog.toString());
            auditLogRepository.save(auditLog);
        }

    }

}
