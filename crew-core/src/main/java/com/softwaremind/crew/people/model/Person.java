package com.softwaremind.crew.people.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Person class represents the Person entity
 * 
 * @author Wiktor Religo
 * @since 09.04.2018
 */
public class Person implements Serializable {
	
	private long id;
	private String firstName;
	private String lastName;
	private String location;
	private String email;
	private String department;
	private String role;
	
	/**
	 * Creating for Testing using Jackson, which requires a default constructor
	 */
	public Person() {
	}
	
	public Person(long id, String firstName, String lastName, String location, String email, String department, String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.email = email;
		this.department = department;
		this.role = role;
	}
	
	public long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Person: {" +
				"id:" + id +
				", firstName:'" + firstName + '\'' +
				", lastName:'" + lastName + '\'' +
				", location:'" + location + '\'' +
				", email:'" + email + '\'' +
				", department:'" + department + '\'' +
				", role:'" + role + '\'' +
				"}";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Person person = (Person) o;
		return id == person.id &&
				Objects.equals(firstName, person.firstName) &&
				Objects.equals(lastName, person.lastName) &&
				Objects.equals(location, person.location) &&
				Objects.equals(email, person.email) &&
				Objects.equals(department, person.department) &&
				Objects.equals(role, person.role);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, location, email, department, role);
	}
	
}
