package com.softwaremind.crew.teams.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.softwaremind.crew.teams.model.Team;
import org.springframework.stereotype.Repository;

@Repository
public class TeamRepository {
	
	private final List<Team> teamList = new LinkedList<>();
	
	/**
	 * Below method add new elements to list
	 * 
	 * @param teamList
	 * @return
	 */
	private final List<Team> teams = new LinkedList<> (Arrays.asList(
			new Team(1L,"jan","mucha","local",6),
			new Team(2L,"ewa","kowalski","remote",7),
			new Team(3L,"jan","mucha","local",3),
			new Team(4L,"jan","mucha","local",2),
			new Team(5L,"jan","mucha","local",5),
			new Team(6L,"jan","mucha","local",6),
			new Team(7L,"jan","mucha","local",7)

	));

	/**
	 * This method return list elements. If list is empty this method initialize add-method
	 * 
	 * @return
	 */
	public final List<Team> getAllTeams() {
		return teams;
	}
	
}
