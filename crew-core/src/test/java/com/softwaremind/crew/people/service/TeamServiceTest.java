package com.softwaremind.crew.people.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.softwaremind.crew.teams.model.Team;
import com.softwaremind.crew.teams.model.TeamDto;
import com.softwaremind.crew.teams.repository.TeamRepository;
import com.softwaremind.crew.teams.service.TeamService;

/**
 * TestSuit for(@link TeamService)
 *
 * @author Mateusz Michoński
 * @author Wiktor Religo
 * @since 16.04.2018
 */
public class TeamServiceTest {
	private TeamService teamService;
	private ModelMapper mapper;
	
	@Mock
	private TeamRepository teamRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		teamService = new TeamService(teamRepository);
		mapper = new ModelMapper();
	}
	
	@Test
	public void shouldReturnAllTeams() {
		initMockServiceTest();
		
		List<TeamDto> resultTeamDtos = teamService.findAll();
		assertThat(resultTeamDtos)
				.extracting("name", "description", "city", "headcount")
				.contains(
						tuple("Name1", "description1", "city1", 2),
						tuple("Name2", "description2", "city2", 5));
	}
	
	@Test
	public void shouldReturnTeamById() {
		Team team1 = new Team(1l, "Name1", "description1", "city1", 2);
		
		Mockito.when(teamRepository.findById(1l)).thenReturn(Optional.ofNullable(team1));
		Optional<TeamDto> teamById = teamService.findTeamById(1l);
		
		assertThat(1l).isEqualTo(teamById.get().getId());
		assertThat(team1.getCity()).isEqualTo(teamById.get().getCity());
	}
	
	@Test
	public void shouldNotReturnTeamById() {
		Mockito.when(teamRepository.findById(2l)).thenReturn(Optional.empty());
		Mockito.when(teamRepository.findById(null)).thenThrow(new IllegalArgumentException("An argument is missing ! "));
		
		Optional<TeamDto> teamById = teamService.findTeamById(2l);
		
		assertThat(teamById).isEmpty();
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> teamService.findTeamById(null))
				.withMessage("An argument is missing ! ");
	}
	
	@Test
	public void shouldAddTeamToDatabase() {
		Team team1 = new Team(1l, "Name1", "description1", "city1", 2);
		
		teamService.createTeam(mapper.map(team1, TeamDto.class));
		
		Mockito.verify(teamRepository, times(1)).save(team1);
	}
	
	@Test
	public void shouldNotAddTeamToDatabase() {
		Mockito.when(teamRepository.save(null)).thenThrow(new IllegalArgumentException());
		
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> teamService.createTeam(null))
				.withMessage("Entity can't be null !");
	}
	
	@Test
	public void shouldDeleteTeamById() {
		teamService.deleteTeamById(1l);
		
		Mockito.verify(teamRepository, times(1)).deleteById(1l);
	}
	
	@Test
	public void shouldNotDeleteTeamById() {
		Mockito.doThrow(new IllegalArgumentException()).when(teamRepository).deleteById(null);
		
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> teamService.deleteTeamById(null))
				.withMessage("Id can't be null !");
	}
	
	@Test
	public void shouldUpdateTeamInDatabase() {
		Team team1 = new Team(1l, "Name1", "description1", "city1", 2);
		
		Mockito.when(teamRepository.save(team1)).thenReturn(team1);
		Mockito.when(teamRepository.findById(1l)).thenReturn(Optional.of(team1));
		Mockito.when(teamRepository.getOne(1l)).thenReturn(team1);
		
		teamService.updateTeamById(1l, mapper.map(team1, TeamDto.class));
		
		Mockito.verify(teamRepository, times(1)).save(team1);
		Mockito.verify(teamRepository, times(1)).findById(1l);
		Mockito.verify(teamRepository, times(1)).getOne(1l);
	}
	
	@Test
	public void shouldNotUpdateTeamToDatabase() {
		TeamDto teamDto = new TeamDto(1l, "TestCase1", "Description1", "Krakow", 12);
		
		Mockito.when(teamRepository.findById(1l)).thenThrow(new TeamService.NoEntityFoundException());
		Mockito.when(teamRepository.findById(2l)).thenThrow(new IllegalArgumentException());
		Mockito.when(teamRepository.findById(null)).thenThrow(new IllegalArgumentException());
		
		assertThatExceptionOfType(TeamService.NoEntityFoundException.class)
				.isThrownBy(() -> teamService.updateTeamById(1l, teamDto))
				.withMessage("There is no Entity in database with given id.");
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> teamService.updateTeamById(null, teamDto))
				.withMessage("Id can't be null ! ");
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> teamService.updateTeamById(2l, null))
				.withMessage("Object can't be null!");
	}
	
	private void initMockServiceTest() {
		Team team1 = new Team(1l, "Name1", "description1", "city1", 2);
		Team team2 = new Team(1l, "Name2", "description2", "city2", 5);
		
		Mockito.when(teamRepository.findAll()).thenReturn(Arrays.asList(team1, team2));
	}
}
