package com.softwaremind.crew.teams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.softwaremind.crew.teams.model.TeamDto;
import com.softwaremind.crew.teams.service.CreateEntityException;
import com.softwaremind.crew.teams.service.NoEntityFoundException;
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
	@PutMapping("teams/{id}")
	public ResponseEntity<?> updateById(@PathVariable(value = "id") Long id, @RequestBody TeamDto teamDto) {
		try {
			teamService.updateTeamById(id, teamDto);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			throw new NoEntityFoundException("Update Team");
		}
	}
	
	/**
	 * Method finds Team by id
	 *
	 * @param id
	 *            of team
	 * @return Team object
	 */
	@GetMapping("teams/{id}")
	public ResponseEntity<TeamDto> findById(@PathVariable Long id) {
		return teamService
				.findTeamById(id)
				.map(ResponseEntity::ok)
				.orElseThrow(() -> new IllegalArgumentException("There is no Team with given ID", new Throwable("Find Team")));
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
		try {
			teamService.deleteTeamById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			throw new IllegalArgumentException("Deleting failed. Object with given id does not exist");
		}
	}
	
	/**
	 * Method creates new Team
	 *
	 * @param teamDto
	 * @return new Team
	 */
	@PostMapping("/teams")
	public ResponseEntity<?> createTeam(@RequestBody TeamDto teamDto) {
		try {
			teamService.createTeam(teamDto);
			return ResponseEntity.ok(teamDto);
		} catch (Exception e) {
			throw new CreateEntityException("Create Team");
		}
	}
}
