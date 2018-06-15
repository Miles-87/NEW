package com.softwaremind.crew.people.integration.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.softwaremind.crew.people.model.Person;
import com.softwaremind.crew.people.model.dto.PersonDto;
import com.softwaremind.crew.people.service.PersonService;
import com.softwaremind.crew.teams.model.Team;
import com.softwaremind.crew.teams.model.TeamDto;
import com.softwaremind.crew.teams.service.TeamService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceIntegrationTest {
	
	@Autowired
	private TeamService teamService;
	@Autowired
	private PersonService personService;
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void shouldAutowireServiceImplementation() {
		assertThat(teamService).isNotNull();
	}
	
	@Test
	@Transactional
	public void shouldAddPersonToTeam() {
		
		// Given
		TeamDto teamDto = new TeamDto(null, "Janek", "local", "wawa", 6);
		PersonDto personDto = new PersonDto(null, "janek", "mucha", "email1@onet.com", "krakow", "Programing", "Developer");
		Team team = teamService.createTeam(teamDto);
		Person person = personService.addPerson(personDto);
		
		// When
		final long personId = person.getId();
		teamService.addPersonsToTeams(team.getId(), personId);
		
		entityManager.flush();
		entityManager.clear();
		// Then
		Optional<Team> teamFromService = teamService.findTeamEntityById(team.getId());
		assertThat(teamFromService.isPresent()).isTrue();
		Set<Person> persons = teamFromService.get().getPersons();
		assertThat(persons).hasSize(1);
		assertThat(persons.stream().filter(person1 -> person1.getId() == personId).findAny()).isPresent();
	}
	
}
