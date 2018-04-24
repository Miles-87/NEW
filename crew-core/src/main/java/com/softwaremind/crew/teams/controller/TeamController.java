package com.softwaremind.crew.teams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.softwaremind.crew.teams.model.TeamDto;
import com.softwaremind.crew.teams.service.TeamService;

/**
 * This class for managing and finding teams
 *
 * @author Mateusz Michoński
 * @author Wiktor Religo
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
	@GetMapping("/teams")
	public List<TeamDto> findAll() {
		return teamService.findAll();
	}
	
	/**
	 * Method update Team by id
	 * 
	 * @param id
	 *            of team
	 * @param teamDto
	 * @return updated Team
	 */
	@PutMapping("team/{id}")
	public TeamDto updateById(@PathVariable(value = "id") long id, @RequestBody TeamDto teamDto) {
		return teamService.updateTeamById(id, teamDto);
	}
	
	/**
	 * Method finds Team by id
	 *
	 * @param id
	 *            of team
	 * @return Team object
	 */
	@GetMapping("teams/{id}")
	public TeamDto findById(@PathVariable Long id) {
		return teamService.findTeamById(id);
	}
	
	/**
	 * Method removes team from database
	 *
	 * @param id
	 *            of team
	 * @return deleted team
	 */
	@DeleteMapping("teams/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		
		return teamService.deleteTeamById(id);
	}
	
	/**
	 * Method creates new Team
	 * 
	 * @param teamDto
	 * @return new Team
	 */
	@PostMapping("teams/add")
	public TeamDto createTeam(@RequestBody TeamDto teamDto) {
		return teamService.createTeam(teamDto);
	}
	
}
