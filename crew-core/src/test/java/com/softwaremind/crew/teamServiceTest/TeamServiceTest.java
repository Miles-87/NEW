package com.softwaremind.crew.teamServiceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.softwaremind.crew.teams.model.Team;
import com.softwaremind.crew.teams.repository.TeamRepository;
import com.softwaremind.crew.teams.service.TeamService;

@RunWith(MockitoJUnitRunner.class)
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

		List<Team> resultTeams = teamService.findAll();
		assertThat(resultTeams).hasSize(2);
	}

	private void initMockServiceTest(){
		Team t1 = new Team(1,"team1","local","wawa",6);
		Team t2 = new Team(2, "team2","remote","krk",7);
		Mockito.when(teamRepository.findAll()).thenReturn(Arrays.asList(t1,t2));
		//Mockito.when(teamRepository.findAll(Matchers.anyOf())).thenReturn(Arrays.asList(t1,t2));
	}
}
