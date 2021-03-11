package com.franchise.qa.controller;


import com.franchise.qa.dao.FranchiseDao;
import com.franchise.qa.persistance.entity.Franchise;
import com.franchise.qa.persistance.repository.FranchiseRepository;
import com.franchise.qa.service.FranchiseServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by noravingal on 08/03/21.
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest")
public class FranchiseController {

    @Autowired
    FranchiseServiceInterface franchiseServiceInterface;

    @PostMapping("/franchise/save")
    public ResponseEntity<Franchise> createFranchise(@RequestBody FranchiseDao franchiseDao){
        return ResponseEntity.ok(franchiseServiceInterface.save(franchiseDao));

    }

    @GetMapping("/franchise/list")
    public ResponseEntity<List<Franchise>>listAll(){
        return ResponseEntity.ok(franchiseServiceInterface.listAll());
    }

}
