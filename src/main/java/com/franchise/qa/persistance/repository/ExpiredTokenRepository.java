package com.franchise.qa.persistance.repository;

import com.franchise.qa.persistance.entity.ExpiredToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by noravingal on 19/04/21.
 */
@Repository
public interface ExpiredTokenRepository extends JpaRepository<ExpiredToken,Long>{
       ExpiredToken findByToken(String token);
}
