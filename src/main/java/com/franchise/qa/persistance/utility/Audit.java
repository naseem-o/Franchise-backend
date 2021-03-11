package com.franchise.qa.persistance.utility;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Created by noravingal on 08/03/21.
 */
public class Audit <T extends BaseEntity> {
    @PrePersist
    public void beforePersist(T e){
        e.setCreatedDate(new Date());
    }

    @PreUpdate
    public void beforeUpdate(T e){
        e.setUpdateDate(new Date());
    }
}
