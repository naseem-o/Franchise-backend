package com.franchise.qa.persistance.repository;

import com.franchise.qa.persistance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by noravingal on 13/04/21.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     User findByUsername(String username);


}
