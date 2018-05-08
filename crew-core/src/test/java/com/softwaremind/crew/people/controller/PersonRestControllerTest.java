package com.softwaremind.crew.people.controller;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
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
import com.softwaremind.crew.people.model.dto.PersonDto;
import com.softwaremind.crew.people.service.PersonService;

/**
 * TestSuit for {@link PersonRestController}
 *
 * @author Wiktor Religo
 * @author Mateusz Michoński
 * @since 10.04.2018
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonRestControllerTest {
	
	private MockMvc mockMvc;
	private ObjectMapper objectMapper;
	@Mock
	private PersonService personService;
	
	@Before
	public void initTest() {
		mockMvc = MockMvcBuilders.standaloneSetup(new PersonRestController(personService)).build();
		objectMapper = new ObjectMapper();
	}
	
	@Test
	public void shouldGetPeopleResource() throws Exception {
		PersonDto personDto = new PersonDto(1L, "Bob", "Noob", "mail@first.pl", "Warszawa", "APPS", "Developer");
		when(personService.findAll()).thenReturn(Collections.singletonList(personDto));
		
		mockMvc.perform(get("/people"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].id").value(personDto.getId()))
				.andExpect(jsonPath("$[0].firstName").value(personDto.getFirstName()))
				.andExpect(jsonPath("$[0].lastName").value(personDto.getLastName()))
				.andExpect(jsonPath("$[0].location").value(personDto.getLocation()))
				.andExpect(jsonPath("$[0].email").value(personDto.getEmail()))
				.andExpect(jsonPath("$[0].status").value(personDto.getStatus()))
				.andExpect(jsonPath("$[0].role").value(personDto.getRole()));
	}
	
	@Test
	public void shouldGetPersonById() throws Exception {
		Long testId = 2L;
		PersonDto personDto = new PersonDto(testId, "Adam", "Kowalski", "kowalski@oo2.pl", "Krawko", "Active", "Manager");
		when(personService.findById(testId)).thenReturn(Optional.of(personDto));
		
		mockMvc.perform(get("/people/" + personDto.getId()))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.id").value(personDto.getId()));
		
	}
	
	@Test
	public void shouldDeletePersonById() throws Exception {
		when(personService.deletePerson(isA(Long.class))).thenReturn(Optional.empty());
		mockMvc.perform(delete("/people/{id}", 1L)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldNotDeletePersonByGivenId() throws Exception {
		Mockito.doThrow(new PersonService.NoEntityFoundException()).when(personService).deletePerson(1L);
		mockMvc.perform(delete("/people/{id}", 1L))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void shouldUpdatePersonById() throws Exception {
		PersonDto person = new PersonDto(1L, "Bob", "Noob", "mail@first.pl", "Warszawa", "APPS", "Developer");
		mockMvc.perform(
				put("/people/{id}", 2l)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.valueToTree(person).toString()))
				.andExpect(status().isOk());
	}
	
	@Test
	public void shouldNotUpdatePersonByPutRequest() throws Exception {
		PersonDto personDto = new PersonDto(1L, "Bob", "Noob", "mail@first.pl", "Warszawa", "APPS", "Developer");
		Mockito.doThrow(new PersonService.NoEntityFoundException()).when(personService).updatePersonById(1l, personDto);
		
		mockMvc.perform(
				put("/people/{id}", 1)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.valueToTree(personDto).toString()))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldSavePersonInDatabase() throws Exception {
		PersonDto personDto = new PersonDto(1L, "Bob", "Noob", "mail@first.pl", "Warszawa", "APPS", "Developer");
		Mockito.doNothing().when(personService).addPerson(personDto);
		
		mockMvc.perform(
				post("/people")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.valueToTree(personDto).toString()))
				.andExpect(status().isOk());
	}
	
	@Test
	public void shouldNotSavePersonToDatabase() throws Exception {
		PersonDto personDto = new PersonDto(1L, "Bob", "Noob", "mail@first.pl", "Warszawa", "APPS", "Developer");
		Mockito.doThrow(new IllegalArgumentException()).when(personService).addPerson(personDto);
		
		mockMvc.perform(
				post("/people")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.valueToTree(personDto).toString()))
				.andExpect(status().isBadRequest());
	}
	
}