package com.softwaremind.crew.people.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
	
	@Mock
	private TeamRepository teamRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		teamService = new TeamService(teamRepository);
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
		Team team1 = new Team("Name1", "description1", "city1", 2);
		
		Mockito.when(teamRepository.findById(1l)).thenReturn(Optional.ofNullable(team1));
		assertThat(teamRepository.findById(1l)).contains(team1);
	}
	
	@Test
	public void shouldNotReturnTeamById() {
		Mockito.when(teamRepository.findById(2l)).thenReturn(Optional.empty());
		assertThat(teamRepository.findById(2l)).isEmpty();
	}
	
	@Test
	public void shouldAddTeamToDatabase() {
		Team team1 = new Team("Name1", "description1", "city1", 2);
		Mockito.when(teamRepository.save(team1)).thenReturn(team1);
		assertThat(teamRepository.save(team1)).isEqualTo(team1);
		
	}
	
	@Test
	public void shouldNotAddTeamToDatabase() {
		Mockito.when(teamRepository.save(null)).thenThrow(new IllegalArgumentException());
		try {
			teamRepository.save(null);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	@Test
	public void shouldDeleteTeamById() {
		teamRepository.deleteById(1l);
		Mockito.verify(teamRepository, times(1)).deleteById(1l);
	}
	
	@Test
	public void shouldNotDeleteTeamById() {
		Mockito.doThrow(new IllegalArgumentException()).when(teamRepository).deleteById(null);
		try {
			teamRepository.deleteById(null);
		} catch (Exception exc) {
			assertThat(exc).isInstanceOf(IllegalArgumentException.class);
		}
		
	}
	
	@Test
	public void shouldUpdateTeamInDatabase() {
		Team team1 = new Team("Name1", "description1", "city1", 2);
		Mockito.when(teamRepository.getOne(1l)).thenReturn(team1);
		Mockito.when(teamRepository.save(team1)).thenReturn(team1);
		
		assertThat(teamRepository.getOne(1l)).isEqualTo(team1);
		assertThat(teamRepository.save(team1)).isEqualTo(team1);
	}
	
	@Test
	public void shouldNotUpdateTeamToDatabase() {
		Mockito.when(teamRepository.getOne(null)).thenThrow(new TeamService.NoEntityFoundException());
		try {
			teamRepository.getOne(null);
			teamRepository.save(null);
		} catch (TeamService.NoEntityFoundException e) {
			assertThat(e.getMessage()).isEqualToIgnoringCase("There is no Entity in database with given id.");
		}
	}
	
	private void initMockServiceTest() {
		Team team1 = new Team("Name1", "description1", "city1", 2);
		Team team2 = new Team("Name2", "description2", "city2", 5);
		
		Mockito.when(teamRepository.findAll()).thenReturn(Arrays.asList(team1, team2));
	}
}
