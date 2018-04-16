package com.softwaremind.crew.teamControllerTest;

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
import com.softwaremind.crew.teams.model.Team;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeamControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
    public void shouldGetTeamsResource() throws Exception{

        MvcResult mvcResult = mockMvc.perform(get("/team"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType((MediaType.APPLICATION_JSON_UTF8)))
                    .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        List<Team> teams = Arrays.asList(mapper.readValue(content,Team[].class));
        assertFalse(content.isEmpty());

        for(Team t : teams){
            assertFalse("some property are empty", Stream.of(t.getId(),t.getName(),t.getDescription(),t.getCity(),t.getHeadcount())
                                                                       .anyMatch(it->(it == null)));

        }
        assertEquals(7,teams.size());
    }
	
}
