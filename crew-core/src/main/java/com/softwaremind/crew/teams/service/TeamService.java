package com.softwaremind.crew.teams.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.softwaremind.crew.teams.model.TeamModel;
import com.softwaremind.crew.teams.repository.TeamRepository;

@Service
public class TeamService {
	
	private final TeamRepository teamRepository;
	
	public TeamService() {
		teamRepository = new TeamRepository();
	}
	
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	/**
	 * Initialize repository method which returns list
	 * 
	 * @return
	 */
	public List<TeamModel> getmyteams() {
		return teamRepository.listStart();
	}
}