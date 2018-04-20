package com.softwaremind.crew.people.model.dto;

import java.time.LocalDate;

/**
 * This class define personDto
 * 
 * @author Mateusz Michoński
 * @since 20.04.2018
 */
public class PersonDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private String location;
	private String status;
	private String role;
	private LocalDate createOn;
	private LocalDate modifiedOn;
	
	public PersonDto() {
	}
	
	public PersonDto(String firstName, String lastName, String email, String location, String status, String role, LocalDate createOn,
			LocalDate modifiedOn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
		this.status = status;
		this.role = role;
		this.createOn = createOn;
		this.modifiedOn = modifiedOn;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
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
		return "PersonDto{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", location='" + location + '\'' +
				", status='" + status + '\'' +
				", role='" + role + '\'' +
				", createOn=" + createOn +
				", modifiedOn=" + modifiedOn +
				'}';
	}
}
