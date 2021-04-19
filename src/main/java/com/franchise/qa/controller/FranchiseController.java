package com.franchise.qa.controller;


import com.franchise.qa.model.FranchiseModel;
import com.franchise.qa.exception.FranchiseBusinessException;
import com.franchise.qa.persistance.entity.Franchise;
import com.franchise.qa.service.FranchiseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by noravingal on 08/03/21.
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest")
public class FranchiseController{

    @Autowired
    FranchiseServiceInterface franchiseServiceInterface;



    @PostMapping("/franchise/save")
    public ResponseEntity<Franchise> createFranchise(@RequestBody FranchiseModel franchiseModel) throws FranchiseBusinessException{
        return ResponseEntity.ok(franchiseServiceInterface.save(franchiseModel));
    }


    @GetMapping("/franchise/list")
    public ResponseEntity<List<Franchise>>listAll(){
        return ResponseEntity.ok(franchiseServiceInterface.listAll());
    }

    //...
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Map<String, Object>> handleException(Exception e) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "ERROR");
        if (e instanceof FranchiseBusinessException) {
            response.put("message", e.getMessage());
        } else {
            response.put("message", "Unexpected Error Occurred");
        }
        return ResponseEntity.badRequest().body(response);
    }

}
