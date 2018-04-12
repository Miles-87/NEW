package com.softwaremind.crew.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaremind.crew.employees.model.Employee;
import com.softwaremind.crew.employees.repository.EmployeesRepository;

/**
 * Employee service class
 * 
 * @author Wiktor Religo
 * @since 10.04.2018
 */
@Service
public class EmployeeService {
	
	private EmployeesRepository employeesRepository;
	
	@Autowired
	public EmployeeService(EmployeesRepository employeesRepository) {
		this.employeesRepository = employeesRepository;
	}
	
	/**
	 * This method returns a set of employees
	 * 
	 * @return set of employees entities
	 */
	public List<Employee> findAll() {
		return employeesRepository.getEmployees();
	}
	
	/**
	 * Method returns an Employee entity selected by id
	 * 
	 * @param id
	 *            of Employee
	 * @return Employee entity
	 */
	public Employee getEmployeeById(long id) {
		return employeesRepository.getEmployees().stream()
				.filter(p -> p.getId() == id)
				.findAny().orElse(null);
	}
	
}
