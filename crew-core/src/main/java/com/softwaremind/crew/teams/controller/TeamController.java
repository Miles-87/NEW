package com.softwaremind.crew.teams.controller;

import java.util.List;

import com.softwaremind.crew.teams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softwaremind.crew.teams.model.TeamModel;
import com.softwaremind.crew.teams.service.TeamService;

@RestController
public class TeamController {

	private TeamService teamService;

	@Autowired
	public TeamController(TeamService teamService){this.teamService = teamService;}

	/**
	 * This method send our set to rest controller
	 */
	@RequestMapping("/team")
	public List<TeamModel>showAll(){
		return teamService.getmyteams();
	}

}
