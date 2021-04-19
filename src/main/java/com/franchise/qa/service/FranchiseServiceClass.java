package com.franchise.qa.service;

import com.franchise.qa.model.FranchiseModel;
import com.franchise.qa.exception.FranchiseBusinessException;
import com.franchise.qa.persistance.entity.Franchise;
import com.franchise.qa.persistance.repository.FranchiseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by noravingal on 08/03/21.
 */

@Service
@Transactional
public class FranchiseServiceClass implements FranchiseServiceInterface {

   @Autowired
    FranchiseRepository franchiseRepository;



    @Override
    public Franchise save(FranchiseModel franchiseModel) throws FranchiseBusinessException{
        try {
            if (franchiseRepository.findByIdNumber(franchiseModel.getIdNumber()) != null) {
                throw new FranchiseBusinessException("Id number already used");
            }
            Franchise franchise = new Franchise();
            BeanUtils.copyProperties(franchiseModel, franchise);
            franchiseRepository.save(franchise);
            return franchise;
        } catch (FranchiseBusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new FranchiseBusinessException("Unexpected Error Occurred");
        }
    }

    @Override
    public List<Franchise> listAll() {

        return franchiseRepository.findAll();
    }


}
