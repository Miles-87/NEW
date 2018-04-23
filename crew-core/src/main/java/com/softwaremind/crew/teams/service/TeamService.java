package com.softwaremind.crew.teams.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaremind.crew.teams.model.Team;
import com.softwaremind.crew.teams.model.TeamDto;
import com.softwaremind.crew.teams.repository.TeamRepository;

/**
 * This class have methods to manage teams
 *
 * @author Mateusz Michoński
 * @author Wiktor Religo
 * @since 09.04.2018
 */
@Service
public class TeamService {
	
	private final TeamRepository teamRepository;
	private final ModelMapper modelMapper;
	
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
		return modelMapper.map(teamRepository.findAll(), new TypeToken<List<TeamDto>>() {
		}.getType());
	}
	
	/**
	 * Method finds Team by id
	 * 
	 * @param id
	 *            of team
	 * @return Team object
	 */
	public TeamDto findTeamById(Long id) {
		return modelMapper.map(teamRepository.findById(id)
				.orElseThrow(NoSuchElementException::new), TeamDto.class);
	}
	
	/**
	 * Method update Team by id
	 *
	 * @param id
	 *            of team
	 * @param teamDto
	 * @return updated Team
	 */
	@Transactional
	public TeamDto updateTeamById(long id, TeamDto teamDto) {
		Optional<Team> team = Optional.of(teamRepository.findById(id))
				.orElseThrow(() -> new ResourceNotFoundException("Team with ID: " + id + " does not exist ! "));
		Team teamEntity = team.get();
		
		teamEntity.setName(teamDto.getName());
		teamEntity.setCity(teamDto.getCity());
		teamEntity.setDescription(teamDto.getDescription());
		teamEntity.setHeadcount(teamDto.getHeadcount());
		teamRepository.save(teamEntity);
		return teamDto;
	}
	
	/**
	 * Method removes team from database
	 * 
	 * @param id
	 *            of team
	 * @return deleted team
	 */
	@Transactional
	public TeamDto deleteTeamById(Long id) {
		Team existTeam = teamRepository.findById(id)
				.orElseThrow(NoSuchElementException::new);
		
		teamRepository.delete(existTeam);
		return modelMapper.map(existTeam, TeamDto.class);
	}
	
	/**
	 * Method creates new Team
	 *
	 * @param teamDto
	 * @return new Team
	 */
	@Transactional
	public TeamDto createTeam(TeamDto teamDto) {
		teamRepository.save(modelMapper.map(teamDto, Team.class));
		return teamDto;
	}
}
