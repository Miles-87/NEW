package com.softwaremind.crew.teams.service;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
	public TeamDto findTeamById(Long id) throws HttpClientErrorException {
		if (teamRepository.findById(id).isPresent()) {
			return modelMapper.map(teamRepository.findById(id).get(), TeamDto.class);
		} else {
			throw new HttpClientErrorException(NOT_FOUND, "No such Element expected");
		}
		
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
	public TeamDto updateTeamById(long id, TeamDto teamDto) throws HttpClientErrorException {
		if (teamRepository.findById(id).isPresent()) {
			Team teamEntity = teamRepository.findById(id).get();
			teamEntity.setName(teamDto.getName());
			teamEntity.setCity(teamDto.getCity());
			teamEntity.setDescription(teamDto.getDescription());
			teamEntity.setHeadcount(teamDto.getHeadcount());
			teamRepository.save(teamEntity);
		} else {
			throw new HttpClientErrorException(NOT_FOUND, "No such Element expected");
		}
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
	public ResponseEntity<?> deleteTeamById(Long id) {
		Team existTeam = teamRepository.findById(id).get();
		
		teamRepository.delete(existTeam);
		return ResponseEntity.ok().build();
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
