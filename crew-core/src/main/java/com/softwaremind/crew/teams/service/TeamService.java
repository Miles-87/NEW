package com.softwaremind.crew.teams.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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
	public TeamService(TeamRepository teamRepository, ModelMapper modelMapper) {
		this.teamRepository = teamRepository;
		this.modelMapper = modelMapper;
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
		Assert.notNull(id, "ID must exist ");
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
	public void updateTeamById(Long id, TeamDto teamDto) throws NoEntityFoundException {
		Assert.notNull(id, "Id can't be null ! ");
		Assert.notNull(teamDto, "Object can't be null!");
		teamRepository.findById(id)
				.map(team -> {
					Team teamEntity = teamRepository.getOne(id);
					teamEntity.setId(teamDto.getId());
					teamEntity.setName(teamDto.getName());
					teamEntity.setCity(teamDto.getCity());
					teamEntity.setDescription(teamDto.getDescription());
					teamEntity.setHeadcount(teamDto.getHeadcount());
					return teamRepository.save(teamEntity);
				}).orElseThrow(() -> new NoEntityFoundException("Update Team"));
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
		Assert.notNull(id, "Id can't be null !");
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
		Assert.notNull(teamDto);
		Assert.notNull(teamDto.getName());
		teamRepository.save(modelMapper.map(teamDto, Team.class));
	}
	
}
