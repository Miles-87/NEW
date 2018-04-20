package com.softwaremind.crew.teams.repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.softwaremind.crew.teams.model.TeamDto;

/**
 * Teams repository class
 *
 * @author Mateusz Michoński
 * @since 09.04.2018
 */
@Repository
public class TeamRepository {
	
	/**
	 * Below method create list and add new elements
	 * 
	 * @param teamList
	 * @return
	 */
	private final List<TeamDto> teamDtos = new LinkedList<>(Arrays.asList(
			new TeamDto(1L, "team1", "local", "wawa", 6),
			new TeamDto(2L, "team2", "remote", "krk", 7),
			new TeamDto(3L, "team3", "local", "wawa", 3),
			new TeamDto(4L, "team4", "remote", "krk", 2),
			new TeamDto(5L, "team5", "local", "wawa", 5),
			new TeamDto(6L, "team6", "remote", "gda", 6),
			new TeamDto(7L, "team7", "local", "krk", 7)
	
	));
	
	/**
	 * This method return all elements of list
	 * 
	 * @return
	 */
	public List<TeamDto> findAll() {
		return teamDtos;
	}
	
}
