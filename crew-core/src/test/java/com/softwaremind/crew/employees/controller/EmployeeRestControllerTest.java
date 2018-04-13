package com.softwaremind.crew.employees.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softwaremind.crew.employees.model.Employee;

/**
 * TestSuit for {@link EmployeeRestController}
 * 
 * @author Wiktor Religo
 * @since 10.04.2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldGetEmployeesResource() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/employees"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		List<Employee> employees = Arrays.asList(mapper.readValue(content, Employee[].class));
		assertFalse(content.isEmpty());
		
		for (Employee e : employees) {
			assertFalse("Some property are empty!",
					Stream.of(e.getId(), e.getEmail(), e.getFirstName(), e.getLastName(), e.getDepartment(), e.getRole())
							.anyMatch(it -> (it == null)));
		}
		
		assertEquals(16, employees.size());
	}
}