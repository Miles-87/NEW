package com.softwaremind.crew.people.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.softwaremind.crew.teams.model.Team;

/**
 * Person class represents the Person entity
 *
 * @author Wiktor Religo
 * @author Mateusz Michoński
 * @since 09.04.2018
 */
@Entity
@Table(name = "Person")
public class Person implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Version
	private Long version;
	
	private String firstName;
	private String lastName;
	private String location;
	private String email;
	private String status;
	private String role;
	private LocalDateTime createdOn;
	private LocalDateTime modifiedOn;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "persons_teams",
			joinColumns = @JoinColumn(name = "person_id"),
			inverseJoinColumns = @JoinColumn(name = "team_id"))
	private Set<Team> teams;
	
	/**
	 * Creating for Testing using Jackson, which requires a default constructor
	 */
	public Person() {
	}
	
	public Person(Long id, String firstName, String lastName, String location, String email, String status, String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.email = email;
		this.status = status;
		this.role = role;
	}
	
	@PrePersist
	public void persistOnCreate() {
		this.createdOn = LocalDateTime.now();
	}
	
	@PreUpdate
	public void updateOnModify() {
		this.modifiedOn = LocalDateTime.now();
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
	
	public LocalDateTime getCreateOn() {
		return createdOn;
	}
	
	public void setCreateOn(LocalDateTime createOn) {
		this.createdOn = createOn;
	}
	
	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}
	
	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	public Set<Team> getTeams() {
		return teams;
	}
	
	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Person))
			return false;
		Person person = (Person) o;
		return getId() == person.getId() &&
				Objects.equals(getFirstName(), person.getFirstName()) &&
				Objects.equals(getLastName(), person.getLastName()) &&
				Objects.equals(getLocation(), person.getLocation()) &&
				Objects.equals(getEmail(), person.getEmail()) &&
				Objects.equals(getStatus(), person.getStatus()) &&
				Objects.equals(getRole(), person.getRole()) &&
				Objects.equals(createdOn, person.createdOn) &&
				Objects.equals(getModifiedOn(), person.getModifiedOn());
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(getId(), getFirstName(), getLastName(), getLocation(), getEmail(), getStatus(), getRole(), createdOn,
				getModifiedOn());
	}
	
	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", location='" + location + '\'' +
				", email='" + email + '\'' +
				", status='" + status + '\'' +
				", role='" + role + '\'' +
				", createdOn=" + createdOn +
				", modifiedOn=" + modifiedOn +
				'}';
	}
}
