package com.softwaremind.crew.teamServiceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.softwaremind.crew.teams.model.Team;
import com.softwaremind.crew.teams.service.TeamService;

public class TeamServiceTest {
	
	private TeamService teamService;
	
	@BeforeEach
	void setup() {
		teamService = new TeamService();
	}
	
	@Test
	void testMethodCheckingIfListIsEmpty() {
		List<Team> result = teamService.findAll();
		assertThat(result)
				.isNotEmpty();
	}
	
	@Test
	void testMethodCheckingSizeOfTheList() {
		List<Team> result = teamService.findAll();
		assertThat(result).hasSize(10);
	}
}
