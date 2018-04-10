package com.softwaremind.crew.teams.service;

import com.softwaremind.crew.teams.model.TeamModel;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class TeamService {
	
	Set<TeamModel> teamModelSet = new HashSet<>();

	/**
	 * This method add elements to Set
	 */

	private void addTeamsToList() {

		TeamModel team1 = new TeamModel(1, "first", "local", "Crakow", 6);
		TeamModel team2 = new TeamModel(2L, "Second", "moblie", "Warsaw", 5);
		TeamModel team3 = new TeamModel(3L, "third", "remote", "Rzeszow", 3);
		TeamModel team4 = new TeamModel(4L, "first", "local", "Crakow", 6);
		TeamModel team5 = new TeamModel(5L, "Second", "moblie", "Warsaw", 5);
		TeamModel team6 = new TeamModel(6L, "third", "remote", "Rzeszow", 3);
		TeamModel team7 = new TeamModel(7L, "first", "local", "Crakow", 6);
		TeamModel team8 = new TeamModel(8L, "Second", "moblie", "Warsaw", 5);
		TeamModel team9 = new TeamModel(9L, "third", "remote", "Rzeszow", 3);
		TeamModel team10 = new TeamModel(10L, "first", "local", "Crakow", 6);
		TeamModel team11 = new TeamModel(11L, "Second", "moblie", "Warsaw", 5);
		TeamModel team12 = new TeamModel(12L, "third", "remote", "Rzeszow", 3);
		teamModelSet.add(team1);
		teamModelSet.add(team2);
		teamModelSet.add(team3);
		teamModelSet.add(team4);
		teamModelSet.add(team5);
		teamModelSet.add(team6);
		teamModelSet.add(team7);
		teamModelSet.add(team8);
		teamModelSet.add(team9);
		teamModelSet.add(team10);
		teamModelSet.add(team11);
		teamModelSet.add(team12);

	}

	/**
	 * call add method
	 *
	 */
	public Set<TeamModel> getMyTeams() {
		addTeamsToList();
		return teamModelSet;
	}
}