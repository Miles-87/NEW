package com.softwaremind.crew.teams.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class define team object
 *
 * @author Mateusz Michoński
 * @since 09.04.2018
 */
public class Team implements Serializable {
	
	private long id;
	private String name;
	private String description;
	private String city;
	private int headcount;
	
	public Team(long id, String name, String description, String city, int headcount) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.city = city;
		this.headcount = headcount;
	}
	
	/**
	 * For jackson
	 */
	public Team() {
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
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getHeadcount() {
		return headcount;
	}
	
	public void setHeadcount(int headcount) {
		this.headcount = headcount;
	}
	
	@Override
	public String toString() {
		return "Team{" +
				"id=" + id + "\n" +
				", name='" + name + '\'' + "\n" +
				", description='" + description + '\'' + "\n" +
				", city='" + city + '\'' + "\n" +
				", headcount=" + headcount + "\n" +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Team team = (Team) o;
		return headcount == team.headcount &&
				Objects.equals(id, team.id) &&
				Objects.equals(name, team.name) &&
				Objects.equals(description, team.description) &&
				Objects.equals(city, team.city);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, city, headcount);
	}
}
