package com.example.restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

	@Mock
	private EmployeeManager employeeManager;

	@InjectMocks
	private EmployeeController employeeController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllEmployees() {
		Employees employees = new Employees();
		employees.getEmployees().add(new Employee("1", "John", "Doe", "john.doe@example.com", "Manager"));
		employees.getEmployees().add(new Employee("2", "Shanmukha Sai", "Rayapati", "rayapati.shanmukhasai@gmail.com", "Software Engineer"));
		employees.getEmployees().add(new Employee("3", "Joseph", "lang", "j.lang@example.com", "Software Engineer"));

		when(employeeManager.getAllEmployees()).thenReturn(employees);

		Employees result = employeeController.getAllEmployees();

		assertEquals(3, result.getEmployees().size());
		verify(employeeManager, times(1)).getAllEmployees();
	}

	@Test
	void testAddEmployee() {
		Employee employee = new Employee("4", "Jane", "Doe", "jane.doe@example.com", "Manager");

		ResponseEntity<Object> responseEntity = employeeController.addEmployee(employee);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("Employee added successfully", responseEntity.getBody());
		verify(employeeManager, times(1)).addEmployee(employee);
	}

}
