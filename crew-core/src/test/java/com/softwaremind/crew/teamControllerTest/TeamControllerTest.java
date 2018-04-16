package com.softwaremind.crew.teamControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.softwaremind.crew.teams.controller.TeamController;
import com.softwaremind.crew.teams.model.Team;
import com.softwaremind.crew.teams.service.TeamService;

/**
 * TestSuit for(@link TeamController)
 *
 * * @author Mateusz Michoński
 * * @since 16.04.2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeamControllerTest {
	
	private MockMvc mockMvc;
	@Mock
	private TeamService teamService;
	
	@Before
	public void initTest() {
		mockMvc = MockMvcBuilders.standaloneSetup(new TeamController(teamService)).build();
	}
	
	@Test
	public void shouldGetTeamsResource() throws Exception {
		Team t1 = new Team(1, "Jan", "local", "wawa", 6);
		Mockito.when(teamService.findAll()).thenReturn(Arrays.asList(t1));
		
		mockMvc.perform(get("/teams"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].id").value(t1.getId()))
				.andExpect(jsonPath("$[0].name").value(t1.getName()))
				.andExpect(jsonPath("$[0].description").value(t1.getDescription()))
				.andExpect(jsonPath("$[0].city").value(t1.getCity()))
				.andExpect(jsonPath("$[0].headcount").value(t1.getHeadcount()));
		
	}
}