package com.softwaremind.crew.people.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;
import java.util.Optional;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softwaremind.crew.teams.controller.TeamController;
import com.softwaremind.crew.teams.model.TeamDto;
import com.softwaremind.crew.teams.service.TeamService;

/**
 * TestSuit for(@link TeamController)
 *
 * @author Mateusz Michoński
 * @author Wiktor Religo
 * @since 16.04.2018
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
		TeamDto teamDto = new TeamDto(1, "Jan", "local", "wawa", 6);
		Mockito.when(teamService.findAll()).thenReturn(Collections.singletonList(teamDto));
		
		mockMvc.perform(get("/teams"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].id").value(teamDto.getId()))
				.andExpect(jsonPath("$[0].name").value(teamDto.getName()))
				.andExpect(jsonPath("$[0].description").value(teamDto.getDescription()))
				.andExpect(jsonPath("$[0].city").value(teamDto.getCity()))
				.andExpect(jsonPath("$[0].headcount").value(teamDto.getHeadcount()));
		
	}
	
	@Test
	public void shouldGetTeamByIdFromPath() throws Exception {
		TeamDto team = new TeamDto(1, "Jan", "local", "wawa", 6);
		Mockito.when(teamService.findTeamById(1l)).thenReturn(Optional.of(team));
		
		mockMvc.perform(get("/teams/" + 1))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.id").value(team.getId()));
	}
	
	@Test
	public void shouldNotGetTeamByIdFromPath() throws Exception {
		Mockito.doThrow(new IllegalArgumentException()).when(teamService).findTeamById(null);
		
		mockMvc.perform(get("/teams/" + 1))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldUpdateTeamByPutRequest() throws Exception {
		TeamDto team = new TeamDto(1, "Jan", "local", "wawa", 6);
		Mockito.doThrow(new IllegalArgumentException()).when(teamService).updateTeamById(1l, te);
		
		mockMvc.perform(
				put("/teams/{id}", 1)
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().valueToTree(team).toString()))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.id").value(team.getId()))
				.andExpect(jsonPath("$.name").value(team.getName()));
	}
	
	@Test
	public void shouldNotUpdateTeamByPutRequest() throws Exception {
		// to DOO
		mockMvc.perform(
				put("/teams/{id}", 1)
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().valueToTree(Boolean.FALSE).toString()))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void shouldDeleteTeamByGivenId() throws Exception {
		Mockito.doCallRealMethod().when(teamService).deleteTeamById(2l);
		// to DOO
		mockMvc.perform(delete("/teams/{id}", 2l)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldNotDeleteTeamByGivenId() {
		
		// TO DO ....
		
	}
	
	@Test
	public void shouldAddTeamToDatabase() {
		// to doo
	}
	
}