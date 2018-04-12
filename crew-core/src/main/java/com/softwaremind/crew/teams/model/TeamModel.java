package com.softwaremind.crew.teams.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class define team object
 */
public class TeamModel implements Serializable {
	
	private long id;
	private String name;
	private String description;
	private String city;
	private int headcount;
	
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
	
	public TeamModel(long id, String name, String description, String city, int headcount) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.city = city;
		this.headcount = headcount;
	}
	
	@Override
	public String toString() {
		return "TeamModel{" +
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
		TeamModel teamModel = (TeamModel) o;
		return headcount == teamModel.headcount &&
				Objects.equals(id, teamModel.id) &&
				Objects.equals(name, teamModel.name) &&
				Objects.equals(description, teamModel.description) &&
				Objects.equals(city, teamModel.city);
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(id, name, description, city, headcount);
		
	}
}
