package com.softwaremind.crew.people.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * TestSuit for {@link Person}
 * 
 * @author Wiktor Religo
 * @since 10.04.2018
 */
public class PersonTest {
	
	private static Person e1;
	private static Person e2;
	
	/**
	 * Method initializes Person class fields with fake data
	 */
	@BeforeClass
	public static void initObjects() {
		e1 = new Person(1, "Tomek", "Nowak", "Krkaów", "email@gmail.com", "APPS", "Developer");
		e2 = new Person(1, "Alicja", "Kowalska", "Warszawa", "email2@gmail.com", "Business", "Designer");
	}
	
	@Test
	public void testEqualsForPerson() {
		assertThat(e1).isEqualTo(e1);
		assertThat(e1).isNotEqualTo(e2);
	}
	
	@Test
	public void testHashCodeForPerson() {
		assertThat(e1.hashCode()).isEqualTo(e1.hashCode());
		assertThat(e1.hashCode()).isNotEqualTo(e2.hashCode());
	}
	
}