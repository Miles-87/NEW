package com.softwaremind.crew.teams.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.softwaremind.crew.teams.model.TeamModel;

@Repository
public class TeamRepository {
	
	private final List<TeamModel> teamModelList = new LinkedList<>();
	
	/**
	 * Below method add new elements to list
	 * 
	 * @param teamModelList
	 * @return
	 */
	private List<TeamModel> addTeamsToList(List<TeamModel> teamModelList) {
		teamModelList.add(new TeamModel(1, "first", "local", "Krakow", 6));
		teamModelList.add(new TeamModel(2, "first", "local", "Krakow", 6));
		teamModelList.add(new TeamModel(3, "first", "local", "Krakow", 6));
		teamModelList.add(new TeamModel(4, "first", "local", "Krakow", 6));
		teamModelList.add(new TeamModel(5, "first", "local", "Krakow", 6));
		teamModelList.add(new TeamModel(6, "first", "local", "Krakow", 6));
		teamModelList.add(new TeamModel(7, "first", "local", "Krakow", 6));
		teamModelList.add(new TeamModel(8, "first", "local", "Krakow", 6));
		teamModelList.add(new TeamModel(9, "first", "local", "Krakow", 6));
		teamModelList.add(new TeamModel(10, "first", "local", "Krakow", 6));
		
		return teamModelList;
	}
	
	/**
	 * This method return list elements. If list is empty this method initialize add-method
	 * 
	 * @return
	 */
	public final List<TeamModel> listStart() {
		if (teamModelList.isEmpty()) {
			addTeamsToList(teamModelList);
		}
		return teamModelList;
	}
	
}
