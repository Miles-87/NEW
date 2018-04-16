package com.softwaremind.crew.teams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwaremind.crew.teams.model.Team;
import com.softwaremind.crew.teams.service.TeamService;

/**
 * This class manage http request
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
	@RequestMapping("/team")
	public List<Team> showAll() {
		return teamService.findAll();
	}
	
}
