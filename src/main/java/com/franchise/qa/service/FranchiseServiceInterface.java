package com.franchise.qa.service;

import com.franchise.qa.model.FranchiseModel;
import com.franchise.qa.exception.FranchiseBusinessException;
import com.franchise.qa.persistance.entity.Franchise;

import java.util.List;

/**
 * Created by noravingal on 08/03/21.
 */
public interface FranchiseServiceInterface {

    Franchise save(FranchiseModel franchiseModel)throws FranchiseBusinessException;

    List<Franchise> listAll();
}
