package com.softwaremind.crew.people.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

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
		assertThat(resultTeamDtos).hasSize(2);
	}
	
	private void initMockServiceTest() {
		Team t1 = new Team("Name1", "description1", "city1", 2);
		Team t2 = new Team("Name2", "description2", "city2", 5);
		
		Mockito.when(teamRepository.findAll()).thenReturn(Arrays.asList(t1, t2));
		
	}
}
