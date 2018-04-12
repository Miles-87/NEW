package com.softwaremind.crew.TeamServiceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.softwaremind.crew.teams.model.TeamModel;
import com.softwaremind.crew.teams.service.TeamService;

public class TeamServiceTest {
	
	private TeamService teamService;
	
	@BeforeEach
	void setup() {
		teamService = new TeamService();
	}
	
	@Test
	void testMethodCheckingIfListIsEmpty() {
		List<TeamModel> result = teamService.getmyteams();
		assertThat(result)
				.isNotEmpty();
	}
	
	@Test
	void testMethodCheckingSizeOfTheList() {
		List<TeamModel> result = teamService.getmyteams();
		assertThat(result).hasSize(10);
	}
}
