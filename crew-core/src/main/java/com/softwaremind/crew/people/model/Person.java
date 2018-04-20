package com.softwaremind.crew.people.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Person class represents the Person entity
 * 
 * @author Mateusz Michoński
 * @since 20.04.2018
 */
@Entity
public class Person implements Serializable {
	
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private String location;
	private String email;
	private String status;
	private String role;
	private LocalDate createOn;
	private LocalDate modifiedOn;
	
	/**
	 * Creating for Testing using Jackson, which requires a default constructor
	 */
	public Person() {
	}
	
	public Person(String firstName, String lastName, String location, String email, String status, String role, LocalDate createOn,
			LocalDate modifiedOn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.email = email;
		this.status = status;
		this.role = role;
		this.createOn = createOn;
		this.modifiedOn = modifiedOn;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public LocalDate getCreateOn() {
		return createOn;
	}
	
	public void setCreateOn(LocalDate createOn) {
		this.createOn = createOn;
	}
	
	public LocalDate getModifiedOn() {
		return modifiedOn;
	}
	
	public void setModifiedOn(LocalDate modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	@Override
	public String toString() {
		return "Person: {" +
				"id:" + id +
				", firstName:'" + firstName + '\'' +
				", lastName:'" + lastName + '\'' +
				", location:'" + location + '\'' +
				", email:'" + email + '\'' +
				", status:'" + status + '\'' +
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
				Objects.equals(status, person.status) &&
				Objects.equals(role, person.role);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, location, email, status, role);
	}
	
}
