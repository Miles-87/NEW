package com.softwaremind.crew.Employees.Controller;

import com.softwaremind.crew.Employees.Model.Employee;
import com.softwaremind.crew.Employees.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * EmployeeRestController  is class to operate on http  requests
 * Class using autowired EmployeeService component
 * @author Wiktor Religo
 * @since 09.04.2018
 */
@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * This method return the set of Employees by html request method GET
	 * Method used employeeService field 
	 * @return set of Employees entities
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public Set<Employee> employeeSet() {
		return employeeService.getEmployeesSet();
		
	}

    /**
     * This method return an Employee entity selected by unique id
     * Method used employeeService field
     * @param id unique id of Employee
     * @return matched Employee
     */
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable long id) {
		return employeeService.getEmployeeById(id);
	}
	
}
