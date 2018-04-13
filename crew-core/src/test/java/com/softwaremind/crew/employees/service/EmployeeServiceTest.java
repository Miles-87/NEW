package com.softwaremind.crew.employees.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.softwaremind.crew.employees.model.Employee;
import com.softwaremind.crew.employees.repository.EmployeeRepository;

/**
 * TestSuit for {@link EmployeeService}
 *
 * @author Wiktor Religo
 * @since 10.04.2018
 */
@RunWith(MockitoJUnitRunner.class)
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
		// Mockito.when(employeeRepository.getEmployees()).thenReturn(new ArrayList<Employee>());
		List<Employee> resultEmployees = employeeService.findAll();
		assertThat(resultEmployees).hasSize(0);
		
	}
	
	@Test
	public void shouldReturnEmployeeById() {
		Employee result = employeeService.getEmployeeById(0);
		System.out.println(result);
		assertThat(result).isNotNull();
		assertThat(result).hasFieldOrPropertyWithValue("id", 0L);
	}
}