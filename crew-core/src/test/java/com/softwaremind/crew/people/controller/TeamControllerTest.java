package com.softwaremind.crew.people.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;
import java.util.Optional;

import com.softwaremind.crew.people.model.Person;
import com.softwaremind.crew.people.model.dto.PersonDto;
import com.softwaremind.crew.people.service.PersonService;

import com.softwaremind.crew.teams.model.Team;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softwaremind.crew.common.NoEntityFoundException;
import com.softwaremind.crew.handlers.GlobalExceptionHandler;
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
	
	private ObjectMapper mappingObject = new ObjectMapper();
	private MockMvc mockMvc;
	@Mock
	private TeamService teamService;
	@Mock
	private PersonService personService;
	
	@Before
	public void initTest() {
		mockMvc = MockMvcBuilders
				.standaloneSetup(new TeamController(teamService, personService))
				.setControllerAdvice(GlobalExceptionHandler.class)
				.build();
	}
	
	@Test
	public void shouldGetTeamsResource() throws Exception {
		TeamDto teamDto = prepareTeamDto();
		when(teamService.findAll()).thenReturn(Collections.singletonList(teamDto));
		
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
		TeamDto team = prepareTeamDto();
		when(teamService.findTeamById(1l)).thenReturn(Optional.of(team));
		
		mockMvc.perform(get("/teams/" + 1))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.id").value(team.getId()));
	}
	
	@Test
	public void shouldNotGetTeamByIdFromPath() throws Exception {
		doThrow(new IllegalArgumentException()).when(teamService).findTeamById(null);
		
		mockMvc.perform(get("/teams/" + 1))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldUpdateTeamByPutRequest() throws Exception {
		TeamDto team = prepareTeamDto();
		mockMvc.perform(
				put("/teams/{id}", 2l)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mappingObject.valueToTree(team).toString()))
				.andExpect(status().isOk());
	}
	
	@Test
	public void shouldNotUpdateTeamByPutRequest() throws Exception {
		TeamDto team = prepareTeamDto();
		doThrow(new NoEntityFoundException()).when(teamService).updateTeamById(1l, team);
		
		mockMvc.perform(
				put("/teams/{id}", 1)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mappingObject.valueToTree(team).toString()))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void shouldDeleteTeamByGivenId() throws Exception {
		doNothing().when(teamService).deleteTeamById(isA(Long.class));
		mockMvc.perform(delete("/teams/{id}", 1))
				.andExpect(status().isOk());
	}
	
	@Test
	public void shouldNotDeleteTeamByGivenId() throws Exception {
		doThrow(new IllegalStateException()).when(teamService).deleteTeamById(1l);
		
		mockMvc.perform(delete("/teams/{id}", 1))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldAddTeamToDatabase() throws Exception {
		TeamDto teamDto = prepareTeamDto();
		doNothing().when(teamService).createTeam(teamDto);
		
		mockMvc.perform(
				post("/teams")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mappingObject.valueToTree(teamDto).toString()))
				.andExpect(status().isOk());
	}
	
	@Test
	public void shouldNotAddTeamToDatabase() throws Exception {
		TeamDto teamDto = prepareTeamDto();

		verify(teamService, times(0)).createTeam(teamDto);
		teamService.createTeam(any());
		
		mockMvc.perform(
				post("/teams")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mappingObject.valueToTree(teamDto).toString()))
				.andReturn();
	}
	
	@Test
	public void shouldAddPersonToTeam() throws Exception {
		// Given
		TeamDto teamDto = prepareTeamDto();
		PersonDto personDto = preparePersonDto();
		// When
		when(teamService.createTeam(teamDto)).thenReturn(new Team());
		when(personService.addPerson(personDto)).thenReturn(new Person());
		// than
		mockMvc.perform(post("/addPeopleToTeams/{teamId}/{personId}", 1, 1))
				.andExpect(status().isOk());
		
	}
	
	private PersonDto preparePersonDto() {
		return new PersonDto(1L, "Bob", "Noob", "mail@first.pl", "Warszawa", "APPS", "Developer");
	}
	
	private TeamDto prepareTeamDto() {
		return new TeamDto(1L, "Jan", "local", "wawa", 6);
	}
	
}