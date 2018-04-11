package com.softwaremind.crew.employees.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaremind.crew.employees.model.Employee;
import com.softwaremind.crew.employees.repository.EmployeeServiceImpl;

/**
 * Employee service class
 * 
 * @author Wiktor Religo
 * @since 10.04.2018
 */
@Service
public class EmployeeService {
	
	private List<Employee> employeeList = new ArrayList<>();
	
	@Autowired
	public EmployeeService(EmployeeServiceImpl serviceImpl) {
		employeeList.addAll(serviceImpl.initList(employeeList));
	}
	
	/**
	 * This method return a set of employees
	 * 
	 * @return set of employees entities
	 */
	public List<Employee> findAll() {
		return employeeList;
	}
	
	/**
	 * Method return an Employee entity selected by id
	 * 
	 * @param id
	 *            of Employee
	 * @return Employee entity
	 */
	public Employee getEmployeeById(long id) {
		return employeeList.stream()
				.filter(p -> p.getId() == id)
				.findAny().orElse(null);
	}
	
}
