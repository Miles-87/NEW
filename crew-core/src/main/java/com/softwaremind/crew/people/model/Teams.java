package com.softwaremind.crew.people.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * Teams class represents Teams as database entity
 *
 * @author Wiktor Religo
 * @since 16.04.2018
 */
@Entity
@Table(name = "Teams")
public class Teams implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private LocalDateTime createdOn;
	private LocalDateTime modifiedOn;
	
	public Teams() {
	}
	
	public Teams(String name, String description, LocalDateTime createdOn, LocalDateTime modifiedOn) {
		this.name = name;
		this.description = description;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}
	
	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	@Override
	public String toString() {
		return "Teams{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", createdOn=" + createdOn +
				", modifiedOn=" + modifiedOn +
				'}';
	}
}
