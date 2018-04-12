package com.softwaremind.crew.employees.model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * TestSuit for {@link Employee}
 * 
 * @author Wiktor Religo
 * @since 10.04.2018
 */
public class EmployeeTest {
	
	private static Employee e1, e2;
	
	/**
	 * Method initializes Employee class fields with fake data
	 */
	@BeforeClass
	public static void initObjects() {
		e1 = new Employee(1, "Tomek", "Nowak", "Krkaów", "email@gmail.com", "APPS", "Developer");
		e2 = new Employee(1, "Alicja", "Kowalska", "Warszawa", "email2@gmail.com", "Business", "Designer");
		System.out.println("Before: Initialization Success");
	}
	
	/**
	 * Method testing POJO equals method
	 */
	@Test
	public void checkEqualsOfObjects() {
		assertEquals(e1.getClass(), e2.getClass());
		assertEquals(e1, e1);
		assertEquals(e2, e2);
		assertFalse(e1.equals(e2));
		assertFalse(e2.equals(e1));
		System.out.println("Equals Test Success");
	}
	
	/**
	 * Method testing POJO hashCode method
	 */
	@Test
	public void checkGeneratedHashCode() {
		int hash1 = e1.hashCode();
		int hash2 = e2.hashCode();
		assertTrue("HashCode should be equals", e1.hashCode() == e1.hashCode());
		assertTrue("HashCode should be equals", e2.hashCode() == e2.hashCode());
		assertTrue("HashCode should not change", hash1 == e1.hashCode());
		assertTrue("HashCode should not change", hash2 == e2.hashCode());
		assertFalse("HashCode should be different", hash2 == hash1);
		System.out.println("HashCode Test Success");
	}
	
	@AfterClass
	public static void afterTest() {
		System.out.println("\nAfter: Test Completed ");
	}
}