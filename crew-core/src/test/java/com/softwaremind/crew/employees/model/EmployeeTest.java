package com.softwaremind.crew.employees.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * TestSuit for {@link Employee}
 * 
 * @author Wiktor Religo
 * @since 10.04.2018
 */
public class EmployeeTest {
	
	private static Employee e1;
	private static Employee e2;
	
	/**
	 * Method initializes Employee class fields with fake data
	 */
	@BeforeClass
	public static void initObjects() {
		e1 = new Employee(1, "Tomek", "Nowak", "Krkaów", "email@gmail.com", "APPS", "Developer");
		e2 = new Employee(1, "Alicja", "Kowalska", "Warszawa", "email2@gmail.com", "Business", "Designer");
	}
	
	@Test
	public void testEqualsForEmployee() {
		assertThat(e1).isEqualTo(e1);
		assertThat(e1).isNotEqualTo(e2);
	}
	
	@Test
	public void testHashCodeForEmployee() {
		assertThat(e1.hashCode()).isEqualTo(e1.hashCode());
		assertThat(e1.hashCode()).isNotEqualTo(e2.hashCode());
	}
	
}