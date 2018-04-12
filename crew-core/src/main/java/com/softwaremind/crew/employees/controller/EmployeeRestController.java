package com.softwaremind.crew.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwaremind.crew.employees.model.Employee;
import com.softwaremind.crew.employees.service.EmployeeService;

/**
 * EmployeeRestController class to operate on http requests
 *
 * @author Wiktor Religo
 * @since 09.04.2018
 */
@RestController
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Method returns all employees
     * Method used employeeService field
     *
     * @return list of employees
     */
    @RequestMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    /**
     * Method returns an Employee entity selected id
     * Method used employeeService field
     *
     * @param id id of Employee
     * @return matched Employee
     */
    @GetMapping(value = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

}
