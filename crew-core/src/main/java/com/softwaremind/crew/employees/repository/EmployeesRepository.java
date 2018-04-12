package com.softwaremind.crew.employees.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.softwaremind.crew.employees.model.Employee;

/**
 * Employees Repository class
 * 
 * @author Wiktor Religo
 * @since 10.04.2018
 */
@Repository
public class EmployeesRepository {
	
	private static final List<Employee> employeeList = new ArrayList<>();
	
	/**
	 * Method initialize list of Employees
	 */
	@PostConstruct
	private static void initEmployees() {
		employeeList.add(new Employee(1, "Wiktor", "Pietrzyk", "Kraków", "email@gmail.com", "IT", "Developer"));
		employeeList.add(new Employee(2, "Tomasz", "Nowak", "Kraków", "email2@gmail.com", "Quality", "UX Designer"));
		employeeList.add(new Employee(3, "Katarzyna", "Janosik", "Radom", "email3@gmail.com", "BHP", "Manager"));
		employeeList.add(new Employee(4, "Anna", "Lewacka", "Radom", "email3@gmail.com", "BHP", "Manager"));
		employeeList.add(new Employee(5, "Janusz", "Górski", "Warszawa", "email4@gmail.com", "IT", "Developer"));
		employeeList.add(new Employee(6, "Tomasz", "Drobny", "Warszawa", "email5@gmail.com", "Administration", "Accountant"));
		employeeList.add(new Employee(7, "Mateusz", "Trybut", "Kraków", "email6@gmail.com", "Finance", ""));
		employeeList.add(new Employee(8, "Marek", "Lesiński", "Poznań", "email7@gmail.com", "IT", "Developer"));
		employeeList.add(new Employee(9, "Paweł", "Apostolski", "Poznań", "email8@gmail.com", "Finance", "Analyst"));
		employeeList.add(new Employee(10, "Jan", "Kowalski", "Gdańsk", "email9@gmail.com", "Marketing", "Specialist"));
		employeeList.add(new Employee(11, "Karolina", "Wójcik", "Sopot", "email10@gmail.com", "IT", "Developer"));
		employeeList.add(new Employee(12, "Ewelina", "Marczyńska", "Gdynia", "email11@gmail.com", "BHP", "Specialist"));
		employeeList.add(new Employee(13, "Anna", "Polowa", "Warszawa", "email12@gmail.com", "Marketing", "Manager"));
		employeeList.add(new Employee(14, "Robert", "Kwaitkowski", "Rzeszów", "email13@gmail.com", "Administration", "Secretary"));
		employeeList.add(new Employee(15, "Wojciech", "Norek", "Radom", "email14@gmail.com", "Finance", "Accountant"));
		employeeList.add(new Employee(16, "Adam", "Jasiński", "Kraków", "email15@gmail.com", "Quality", "Engineer"));
	}
	
	/**
	 * Method returns Employees object list
	 * 
	 * @return list of Employees
	 */
	public static List<Employee> getEmployees() {
		return employeeList;
	}
}
