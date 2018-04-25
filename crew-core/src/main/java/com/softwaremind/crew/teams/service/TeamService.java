package com.softwaremind.crew.teams.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
	public Optional<TeamDto> findTeamById(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("An argument is missing ! ");
		}
		return teamRepository
				.findById(id)
				.map(p -> modelMapper.map(p, TeamDto.class));
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
	public Optional<TeamDto> updateTeamById(long id, TeamDto teamDto) {
		if (teamRepository.findById(id).isPresent()) {
			Team teamEntity = teamRepository.getOne(id);
			teamEntity.setName(teamDto.getName());
			teamEntity.setCity(teamDto.getCity());
			teamEntity.setDescription(teamDto.getDescription());
			teamEntity.setHeadcount(teamDto.getHeadcount());
			teamRepository.save(teamEntity);
			return Optional.of(modelMapper.map(teamEntity, TeamDto.class));
		} else {
			throw new IllegalArgumentException("NO such entity in database with given ID  ");
		}
	}
	
	/**
	 * Method removes team from database
	 * 
	 * @param id
	 *            of team
	 * @return deleted team
	 */
	@Transactional
	public void deleteTeamById(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("An argument is missing ! ");
		}
		teamRepository.deleteById(id);
	}
	
	/**
	 * Method creates new Team
	 *
	 * @param teamDto
	 * @return new Team
	 */
	@Transactional
	public void createTeam(TeamDto teamDto) {
		if (Optional.ofNullable(teamDto).isPresent()) {
			teamRepository.save(modelMapper.map(teamDto, Team.class));
		} else {
			throw new IllegalArgumentException("Wrong argument to save");
		}
	}
}
