package com.softwaremind.crew.teams.controller;

import com.softwaremind.crew.teams.model.TeamModel;
import com.softwaremind.crew.teams.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class TeamController {
	
	@Autowired
	TeamService teamService;


	/**
	 * This method send our set to rest controller
	 */

	@RequestMapping("/teams")
	public Set<TeamModel> showTeams() {
		return teamService.myTeams();
	}
	
}
