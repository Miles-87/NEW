package com.softwaremind.crew.people.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

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
		Person e1 = new Person(1, "Bob", "Noob", "Warszawa", "email@gmail.com", "APPS", "Developer");
		when(personService.findAll()).thenReturn(Arrays.asList(e1));
		
		mockMvc.perform(get("/people"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].id").value(e1.getId()))
				.andExpect(jsonPath("$[0].firstName").value(e1.getFirstName()))
				.andExpect(jsonPath("$[0].lastName").value(e1.getLastName()))
				.andExpect(jsonPath("$[0].location").value(e1.getLocation()))
				.andExpect(jsonPath("$[0].email").value(e1.getEmail()))
				.andExpect(jsonPath("$[0].department").value(e1.getDepartment()))
				.andExpect(jsonPath("$[0].role").value(e1.getRole()));
	}
}