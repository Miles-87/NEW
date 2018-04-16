package com.softwaremind.crew.teams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwaremind.crew.teams.model.Team;
import com.softwaremind.crew.teams.service.TeamService;

/**
 * This class operate on http requests
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
	 * This method send our List to rest controller
	 * 
	 * @return
	 */
	@RequestMapping("/teams")
	public List<Team> findAll() {
		return teamService.findAll();
	}
	
}
