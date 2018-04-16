package com.softwaremind.crew.employees.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaremind.crew.employees.model.Employee;
import com.softwaremind.crew.employees.repository.EmployeeRepository;

/**
 * EmployeeService class for managing {@link EmployeeRepository}
 * 
 * @author Wiktor Religo
 * @since 10.04.2018
 */
@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	/**
	 * Method returns a set of employees
	 * 
	 * @return set of employees entities
	 */
	public List<Employee> findAll() {
		return employeeRepository.getEmployees();
	}
	
	/**
	 * Method returns an Employee entity selected by id
	 * 
	 * @param id
	 *            of Employee
	 * @return Employee entity
	 */
	public Employee getEmployeeById(long id) {
		
		return employeeRepository.getEmployees()
				.stream()
				.filter(p -> p.getId() == id)
				.findAny().orElseThrow(NoSuchElementException::new);
		
	}
	
}
