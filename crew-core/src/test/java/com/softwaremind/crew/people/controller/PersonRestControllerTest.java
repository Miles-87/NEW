package com.softwaremind.crew.people.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import com.softwaremind.crew.people.model.dto.PersonDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.softwaremind.crew.people.model.Person;
import com.softwaremind.crew.people.service.PersonService;

/**
 * TestSuit for {@link PersonRestController}
 * 
 * @author Wiktor Religo
 * @since 10.04.2018
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonRestControllerTest {
	
	private MockMvc mockMvc;
	@Mock
	private PersonService personService;
	
	@Before
	public void initTest() {
		mockMvc = MockMvcBuilders.standaloneSetup(new PersonRestController(personService)).build();
	}
	
	@Test
	public void shouldGetPeopleResource() throws Exception {
		PersonDto personDto = new PersonDto(1L, "Bob", "Noob", "Warszawa", "email@gmail.com", "APPS", "Developer");
		when(personService.findAll()).thenReturn(Collections.singletonList(personDto));
		
		mockMvc.perform(get("/people"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].firstName").value(personDto.getFirstName()))
				.andExpect(jsonPath("$[0].lastName").value(personDto.getLastName()))
				.andExpect(jsonPath("$[0].location").value(personDto.getLocation()))
				.andExpect(jsonPath("$[0].email").value(personDto.getEmail()))
				.andExpect(jsonPath("$[0].department").value(personDto.getStatus()))
				.andExpect(jsonPath("$[0].role").value(personDto.getRole()));
	}
}
