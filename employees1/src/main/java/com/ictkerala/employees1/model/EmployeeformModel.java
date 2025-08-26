package com.ictkerala.employees1.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class EmployeeformModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @JsonProperty("name")
    private String name;
    @JsonProperty("designation")
    private String designation;
    @JsonProperty("location")
    private String location;
    @JsonProperty("salary")
    private int salary;

    public EmployeeformModel() {
    }

    public EmployeeformModel(int id, String name, String designation, String location, int salary) {
        Id = id;
        this.name = name;
        this.designation = designation;
        this.location = location;
        this.salary = salary;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
