package com.ictkerala.employees1.repo;


import com.ictkerala.employees1.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface LoginRepo  extends JpaRepository<LoginModel, Integer> {



    //@Query(value = "SELECT username,password  FROM login_model", nativeQuery = true)
    //List<Map<String, String>> findAllLogin();
    Optional<LoginModel> findByUsernameAndPassword(String username, String password);

}
