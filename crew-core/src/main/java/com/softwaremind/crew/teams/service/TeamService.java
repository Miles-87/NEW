package com.softwaremind.crew.teams.service;

import java.util.List;

import com.softwaremind.crew.teams.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaremind.crew.teams.repository.TeamRepository;

/**
 * This class have methods to manage teams
 *
 * @author Mateusz Michoński
 * @since 09.04.2018
 */
@Service
public class TeamService {
	
	private final TeamRepository teamRepository;
	
	@Autowired
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	/**
	 * This method return a set of teams
	 *
	 * @return
	 */
	public List<Team> findAll() {
		return teamRepository.findAll();
	}
}
