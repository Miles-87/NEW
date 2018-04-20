package com.softwaremind.crew.teams.model;

import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * Team represents entity in the database
 *
 * @author Wiktor Religo
 * @since 19.04.2018
 */
@Entity
@Table(name = "Team")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private Long version;
	
	private String name;
	private String description;
	private LocalDateTime createdOn;
	private LocalDateTime modifiedOn;
	
	/**
	 * Default constructor using for ModelMapper
	 */
	public Team() {
	}
	
	public Team(Long version, String name, String description) {
		this.version = version;
		this.name = name;
		this.description = description;
	}
	
	/*
	 * Method sets creation time of the object
	 */
	@PrePersist
	public void persistOnCreate() {
		this.createdOn = LocalDateTime.now();
	}
	
	/*
	 * Method sets modification time of the object
	 */
	@PreUpdate
	public void updateOnModify() {
		this.modifiedOn = LocalDateTime.now();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
		return "Team{" +
				"id=" + id +
				", version=" + version +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", createdOn=" + createdOn +
				", modifiedOn=" + modifiedOn +
				'}';
	}
}
