package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    @GetMapping("/employees")
    public Employees getAllEmployees() {
        return employeeManager.getAllEmployees();
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        if (employee == null){
            return ResponseEntity.notFound().build();
        }
        employeeManager.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee added successfully");
    }

}
