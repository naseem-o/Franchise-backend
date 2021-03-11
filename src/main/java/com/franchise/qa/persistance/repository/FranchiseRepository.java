package com.franchise.qa.persistance.repository;

import com.franchise.qa.persistance.entity.Franchise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by noravingal on 07/03/21.
 */
@Repository
public interface FranchiseRepository extends CrudRepository<Franchise,Long> {
     List<Franchise> findAll();
}
