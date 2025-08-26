package com.ictkerala.employees1.controller;


import com.ictkerala.employees1.model.EmployeeformModel;
import com.ictkerala.employees1.repo.EmployeeformRepo;
import com.ictkerala.employees1.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:5174")
public class EmployeeformController {


    @Autowired
    public EmployeeformRepo repo;

    @PostMapping("/addEmp")
    public ResponseEntity<Map<String, String>> addEmp(@RequestBody EmployeeformModel input) {
        Map<String, String> response = new HashMap<>();
        try {
            EmployeeformModel emp = repo.save(input);
            if (emp.getId() != 0) {
                response.put("status", "Successfully Added");

            } else {
                response.put("status", "Error occurred");
            }
        } catch (Exception e) {
            response.put("status", "Error");
            response.put("message", e.getMessage());
        }

        return ResponseEntity.ok(response);
    }

}
