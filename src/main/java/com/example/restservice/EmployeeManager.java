package com.example.restservice;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.Arrays;

@Repository
public class EmployeeManager {

    private static final Employees employees = new Employees();

    public EmployeeManager() {
        employees.getEmployees().add(new Employee("1", "John", "Doe", "john.doe@example.com", "Manager"));
        employees.getEmployees().add(new Employee("2", "Shanmukha Sai", "Rayapati", "rayapati.shanmukhasai@gmail.com", "Software Engineer"));
        employees.getEmployees().add(new Employee("3", "Joseph", "lang", "j.lang@example.com", "Software Engineer"));
    }

    public Employees getAllEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        if(employee != null){
            employees.getEmployees().add(employee);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
