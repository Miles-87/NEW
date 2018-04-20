package com.softwaremind.crew.teams.repository;

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
	 * (In the future) after setting up Database
	 * Below list will store Team Entities
	 */
	private final List<Team> teams = new LinkedList<>();
	
	/**
	 * This method return all elements of list
	 * 
	 * @return
	 */
	public List<Team> findAll() {
		return teams;
	}
	
}
