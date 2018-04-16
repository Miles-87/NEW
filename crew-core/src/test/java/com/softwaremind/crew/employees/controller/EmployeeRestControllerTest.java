package com.softwaremind.crew.employees.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.softwaremind.crew.employees.model.Employee;
import com.softwaremind.crew.employees.service.EmployeeService;

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
	
	private MockMvc mockMvc;
	@Mock
	private EmployeeService employeeService;
	
	@Before
	public void initTest() {
		mockMvc = MockMvcBuilders.standaloneSetup(new EmployeeRestController(employeeService)).build();
	}
	
	@Test
	public void shouldGetEmployeesResource() throws Exception {
		Employee e1 = new Employee(1, "Bob", "Noob", "Warszawa", "email@gmail.com", "APPS", "Developer");
		Mockito.when(employeeService.findAll()).thenReturn(Arrays.asList(e1));
		
		mockMvc.perform(get("/employees"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(e1.getId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value(e1.getFirstName()))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName").value(e1.getLastName()))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].location").value(e1.getLocation()))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value(e1.getEmail()))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].department").value(e1.getDepartment()))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].role").value(e1.getRole()));
	}
}