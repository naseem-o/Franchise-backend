package com.franchise.qa.service;

import com.franchise.qa.dao.FranchiseDao;
import com.franchise.qa.exception.FranchiseBusinessException;
import com.franchise.qa.persistance.entity.Franchise;
import com.franchise.qa.persistance.repository.FranchiseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noravingal on 08/03/21.
 */

@Service
public class FranchiseServiceClass implements FranchiseServiceInterface {

   @Autowired
    FranchiseRepository franchiseRepository;



    @Override
    @Transactional
    public Franchise save(FranchiseDao franchiseDao) throws FranchiseBusinessException{
        try {
            if (franchiseRepository.findByIdNumber(franchiseDao.getIdNumber()) != null) {
                throw new FranchiseBusinessException("Id number already used");
            }
            Franchise franchise = new Franchise();
            BeanUtils.copyProperties(franchiseDao, franchise);
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
        List<Franchise> franchiseList = new ArrayList<>();

        return franchiseRepository.findAll();
    }


}
