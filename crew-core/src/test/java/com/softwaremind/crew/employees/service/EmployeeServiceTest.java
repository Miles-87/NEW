package com.softwaremind.crew.employees.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.softwaremind.crew.employees.model.Employee;
import com.softwaremind.crew.employees.repository.EmployeeRepository;

/**
 * TestSuit for {@link EmployeeService}
 *
 * @author Wiktor Religo
 * @since 10.04.2018
 */

public class EmployeeServiceTest {
	
	private EmployeeService employeeService;
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@Before
	public void initTest() {
		MockitoAnnotations.initMocks(this);
		employeeService = new EmployeeService(employeeRepository);
	}
	
	@Test
	public void shouldReturnAllEmployees() {
		initMockRepositoryToTest();
		
		List<Employee> resultEmployees = employeeService.findAll();
		assertThat(resultEmployees).hasSize(2);
	}
	
	@Test
	public void shouldReturnEmployeeById() {
		initMockRepositoryToTest();
		
		Employee result = employeeService.getEmployeeById(3l);
		assertThat(result).isNotNull();
		assertThat(result).hasFieldOrPropertyWithValue("id", 3l);
	}
	
	private void initMockRepositoryToTest() {
		Employee e1 = new Employee(1, "Tomek", "Nowak", "Krkaów", "email@gmail.com", "APPS", "Developer");
		Employee e2 = new Employee(3, "Alicja", "Kowalska", "Warszawa", "email2@gmail.com", "Business", "Designer");
		Mockito.when(employeeRepository.getEmployees()).thenReturn(Arrays.asList(e1, e2));
	}
}