package com.softwaremind.crew.teams.repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.softwaremind.crew.teams.model.Team;

/**
 * Teams repository class
 *
 * @author Mateusz Michoński
 * @since 09.04.2018
 */
@Repository
public class TeamRepository {
	
	/**
	 * below method create list and add new elements
	 * 
	 * @param teamList
	 * @return
	 */
	private final List<Team> teams = new LinkedList<>(Arrays.asList(
			new Team(1L, "team1", "local", "wawa", 6),
			new Team(2L, "team2", "remote", "krk", 7),
			new Team(3L, "team3", "local", "wawa", 3),
			new Team(4L, "team4", "remote", "krk", 2),
			new Team(5L, "team5", "local", "wawa", 5),
			new Team(6L, "team6", "remote", "gda", 6),
			new Team(7L, "team7", "local", "krk", 7)
	
	));
	
	/**
	 * this method return all elements of list
	 * 
	 * @return
	 */
	public List<Team> findAll() {
		return teams;
	}
	
}
