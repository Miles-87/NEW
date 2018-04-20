package com.softwaremind.crew.teamServiceTest;

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
		Team t1 = new Team(1l, "Nazwa1", "description1");
		Team t2 = new Team(2l, "Nazwa1", "description1");
		
		Mockito.when(teamRepository.findAll()).thenReturn(Arrays.asList(t1, t2));
		
	}
}
