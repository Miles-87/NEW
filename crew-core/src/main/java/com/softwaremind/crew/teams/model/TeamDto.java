package com.softwaremind.crew.teams.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class define team object
 *
 * @author Mateusz Michoński
 * @author Wiktor Religo
 * @since 09.04.2018
 */
public class TeamDto implements Serializable {
	
	private Long id;
	private String name;
	private String description;
	private String city;
	private Integer headcount;
	
	public TeamDto(long id, String name, String description, String city, Integer headcount) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.city = city;
		this.headcount = headcount;
	}
	
	/**
	 * For jackson
	 */
	public TeamDto() {
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
	
	public Integer getHeadcount() {
		return headcount;
	}
	
	public void setHeadcount(Integer headcount) {
		this.headcount = headcount;
	}
	
	@Override
	public String toString() {
		return "TeamDto{" + "\n" +
				"  id= " + id + "\n" +
				", name='" + name + '\'' + "\n" +
				", description='" + description + '\'' + "\n" +
				", city='" + city + '\'' + "\n" +
				", headcount=" + headcount + "\n" +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TeamDto teamDto = (TeamDto) o;
		return Objects.equals(id, teamDto.id) &&
				Objects.equals(name, teamDto.name) &&
				Objects.equals(description, teamDto.description) &&
				Objects.equals(city, teamDto.city) &&
				Objects.equals(headcount, teamDto.headcount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, city, headcount);
	}
}
