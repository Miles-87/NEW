package com.softwaremind.crew.employees.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.softwaremind.crew.employees.model.Employee;
import com.softwaremind.crew.employees.repository.EmployeesRepository;

/**
 * TestSuit for {@link EmployeeService}
 *
 * @author Wiktor Religo
 * @since 10.04.2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * Method tests returning the list of Employees
	 */
	@Test
	public void shouldReturnAllEmployees() {
		List<Employee> expectedEmployees = EmployeesRepository.getEmployees();
		
		List<Employee> resultEmployees = employeeService.findAll();
		
		assertFalse(resultEmployees.isEmpty());
		assertEquals(expectedEmployees, resultEmployees);
	}
	
	/**
	 * Method tests returning an Employee with the given id
	 */
	@Test
	public void shouldReturnEmployeeById() {
		List<Employee> storedEmployees = EmployeesRepository.getEmployees();
		Employee expectedEmployee = storedEmployees.stream()
				.filter(p -> (p.getId() == 10))
				.findAny().orElse(null);
		
		Employee foundEmployee = employeeService.getEmployeeById(10);
		
		assertNotNull(expectedEmployee);
		assertEquals(expectedEmployee, foundEmployee);
	}
}