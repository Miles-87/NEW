package com.softwaremind.crew.teams.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return modelMapper.map(teamRepository.findAll(), new TypeToken<List<TeamDto>>() {
		}.getType());
	}
}
