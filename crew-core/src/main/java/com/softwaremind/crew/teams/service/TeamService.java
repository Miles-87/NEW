package com.softwaremind.crew.teams.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaremind.crew.teams.model.Team;
import com.softwaremind.crew.teams.model.TeamDto;
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
	private ModelMapper modelMapper;
	
	@Autowired
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
		this.modelMapper = new ModelMapper();
	}
	
	/**
	 * This method return a list of teams
	 *
	 * @return
	 */
	public List<TeamDto> findAll() {
		
		return teamRepository.findAll();
	}
	
	/**
	 * Method mapping {@link Team} entity to {@link TeamDto} class
	 * 
	 * @param team
	 * @return instance of {@link TeamDto}
	 */
	
	public TeamDto mapTeamEntityToDto(Team team) {
		TeamDto teamDto = modelMapper.map(team, TeamDto.class);
		return teamDto;
	}
	
	/**
	 * Method mapping {@link TeamDto} class to {@link Team} entity
	 * 
	 * @param teamDto
	 * @return instance of {@link Team} entity
	 */
	public Team mapDtoToTeamEntity(TeamDto teamDto) {
		Team team = modelMapper.map(teamDto, Team.class);
		team.setCreatedOn(LocalDateTime.now());
		team.setModifiedOn(LocalDateTime.now());
		return team;
	}
}
