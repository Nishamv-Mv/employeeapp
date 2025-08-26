package com.ictkerala.employees1.repo;


import com.ictkerala.employees1.model.EmployeeformModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface EmployeeformRepo extends JpaRepository<EmployeeformModel, Integer> {

    @Query(value = "SELECT name,designation,location,salary FROM employeeform_model", nativeQuery = true)
    List<Map<String, String>> findAllEmployees();

}
