package com.softwaremind.crew.people.integration.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.softwaremind.crew.people.model.Person;
import com.softwaremind.crew.people.model.dto.PersonDto;
import com.softwaremind.crew.people.model.dto.PersonWithTeamsDto;
import com.softwaremind.crew.people.service.PersonService;
import com.softwaremind.crew.teams.model.Team;
import com.softwaremind.crew.teams.model.TeamDto;
import com.softwaremind.crew.teams.service.TeamService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceIntegrationTest {
	
	@Autowired
	private PersonService personService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void shouldAutowireServiceImplementation() {
		assertThat(personService).isNotNull();
	}
	
	@Test
	@Transactional
	public void shouldReturnPeopleWithTeamsAssigned() {
		
		// Given
		TeamDto teamDto = new TeamDto(null, "Janek", "local", "wawa", 6);
		PersonDto personDto = new PersonDto(null, "janek", "mucha", "email1@onet.com", "krakow", "Programing", "Developer");
		Team team = teamService.createTeam(teamDto);
		Person person = personService.addPerson(personDto);
		
		// When
		teamService.addPersonsToTeams(team.getId(), person.getId());
		entityManager.flush();
		personService.peopelWithTeamsAssigned();
		entityManager.clear();
		// Then
		List<PersonWithTeamsDto> personWithTeamsDtos = personService.peopelWithTeamsAssigned();
		assertThat(personWithTeamsDtos.size());
		
	}
}
