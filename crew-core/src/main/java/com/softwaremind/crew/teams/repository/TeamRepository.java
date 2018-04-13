package com.softwaremind.crew.teams.repository;

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
	private List<Team> addTeamsToList(List<Team> teamList) {
		teamList.add(new Team(1, "first", "local", "Krakow", 6));
		teamList.add(new Team(2, "first", "local", "Krakow", 6));
		teamList.add(new Team(3, "first", "local", "Krakow", 6));
		teamList.add(new Team(4, "first", "local", "Krakow", 6));
		teamList.add(new Team(5, "first", "local", "Krakow", 6));
		teamList.add(new Team(6, "first", "local", "Krakow", 6));
		teamList.add(new Team(7, "first", "local", "Krakow", 6));
		teamList.add(new Team(8, "first", "local", "Krakow", 6));
		teamList.add(new Team(9, "first", "local", "Krakow", 6));
		teamList.add(new Team(10, "first", "local", "Krakow", 6));
		
		return teamList;
	}
	
	/**
	 * This method return list elements. If list is empty this method initialize add-method
	 * 
	 * @return
	 */
	public final List<Team> getTeams() {
		if (teamList.isEmpty()) {
			addTeamsToList(teamList);
		}
		return teamList;
	}
	
}
