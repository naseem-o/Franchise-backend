package com.franchise.qa.service;

import com.franchise.qa.dao.FranchiseDao;
import com.franchise.qa.exception.FranchiseBusinessException;
import com.franchise.qa.persistance.entity.Franchise;
import com.franchise.qa.persistance.repository.FranchiseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Franchise save(FranchiseDao franchiseDao){
        Franchise franchise = new Franchise();
        try {
            if (franchiseRepository.findByIdNumber(franchiseDao.getIdNumber()) != null) {
                throw new FranchiseBusinessException("Id number already present");
            }
            BeanUtils.copyProperties(franchiseDao, franchise);
            franchiseRepository.save(franchise);

        }catch (FranchiseBusinessException fe){
            System.err.print(fe);
        }
        return franchise;
    }

    @Override
    public List<Franchise> listAll() {
        List<Franchise> franchiseList = new ArrayList<>();

        return franchiseRepository.findAll();
    }


}
