package com.softwaremind.crew.teams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaremind.crew.teams.repository.TeamRepository;

/**
 * Team service class
 */
@Service
public class TeamService {
	
	private final TeamRepository teamRepository;

	@Autowired
	public TeamService() {
		teamRepository = new TeamRepository();
	}
	
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	/**
	 *This method return a set of teams
	 *
	 * @return
	 */
	public List<TeamModel> findAll() {
		return teamRepository.listStart();
	}
}