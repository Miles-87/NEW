package com.softwaremind.crew.Employees.Service;

import com.softwaremind.crew.Employees.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 *  Employe
 */
@Service
public class EmployeeService {
	
	private static Set<Employee> employeeSet;
	
	public EmployeeService() {
		this.employeeSet = new HashSet<Employee>() {
			{
				add(new Employee(1, "Wiktor", "Pietrzyk", "Kraków", "email@gmail.com", "IT", "Developer"));
				add(new Employee(2, "Tomasz", "Nowak", "Kraków", "email2@gmail.com", "Quality", "UX Designer"));
				add(new Employee(3, "Katarzyna", "Janosik", "Radom", "email3@gmail.com", "BHP", "Manager"));
				add(new Employee(4, "Anna", "Lewacka", "Radom", "email3@gmail.com", "BHP", "Manager"));
				add(new Employee(5, "Janusz", "Górski", "Warszawa", "email4@gmail.com", "IT", "Developer"));
				add(new Employee(6, "Tomasz", "Drobny", "Warszawa", "email5@gmail.com", "Administration", "Accountant"));
				add(new Employee(7, "Mateusz", "Trybut", "Kraków", "email6@gmail.com", "Finance", ""));
				add(new Employee(8, "Marek", "Lesiński", "Poznań", "email7@gmail.com", "IT", "Developer"));
				add(new Employee(9, "Paweł", "Apostolski", "Poznań", "email8@gmail.com", "Finance", "Analyst"));
				add(new Employee(10, "Jan", "Kowalski", "Gdańsk", "email9@gmail.com", "Marketing", "Specialist"));
				add(new Employee(11, "Karolina", "Wójcik", "Sopot", "email10@gmail.com", "IT", "Developer"));
				add(new Employee(12, "Ewelina", "Marczyńska", "Gdynia", "email11@gmail.com", "BHP", "Specialist"));
				add(new Employee(13, "Anna", "Polowa", "Warszawa", "email12@gmail.com", "Marketing", "Manager"));
				add(new Employee(14, "Robert", "Kwaitkowski", "Rzeszów", "email13@gmail.com", "Administration", "Secretary"));
				add(new Employee(15, "Wojciech", "Norek", "Radom", "email14@gmail.com", "Finance", "Accountant"));
				add(new Employee(16, "Adam", "Jasiński", "Kraków", "email15@gmail.com", "Quality", "Engineer"));
			}
		};
	}

	/**
	 * This method return a set of Employees
	 * @return  set of Employees entities
	 */
	public Set<Employee> getEmployeesSet() {
		return employeeSet;
	}

	/**
	 * This method return an Employee entity selected by unique id
	 * @param id  unique for entity
	 * @return  Employee object 
	 */
	public Employee getEmployeeById(long id) {
		return employeeSet.stream()
				.filter(p->p.getId()==id)
				.findAny().orElse(null);
	}
	
}
