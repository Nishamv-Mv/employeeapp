package com.ictkerala.employees1.controller;


import com.ictkerala.employees1.model.LoginModel;
import com.ictkerala.employees1.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins="http://localhost:5173")
public class LoginController {


    @Autowired
    public LoginRepo repo;

    public static Map<String, String> tokenStore = new HashMap<>();

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> addlogin(@RequestBody LoginModel input) {
        Map<String, String> response = new HashMap<>();


        Optional<LoginModel> user = repo.findByUsernameAndPassword(input.getUsername(), input.getPassword());

        if (user.isPresent()) {
            String token = UUID.randomUUID().toString();
            tokenStore.put(token, input.getUsername());
            response.put("status", "success");
            response.put("token", token);
        } else {
            response.put("status", "invalid");
        }

        return ResponseEntity.ok(response);
    }
}
