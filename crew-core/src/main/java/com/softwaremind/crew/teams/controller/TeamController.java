package com.softwaremind.crew.teams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwaremind.crew.teams.model.Team;
import com.softwaremind.crew.teams.service.TeamService;

/**
 * This class for managing and finding teams
 *
 * @author Mateusz Michoński
 * @since 09.04.2018
 */
@RestController
public class TeamController {
	
	private final TeamService teamService;
	
	@Autowired
	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}
	
	/**
	 * This method return all teams
	 * 
	 * @return
	 */
	@RequestMapping("/teams")
	public List<Team> findAll() {
		return teamService.findAll();
	}
	
}
