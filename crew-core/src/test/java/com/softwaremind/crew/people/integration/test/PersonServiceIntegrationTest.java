package com.softwaremind.crew.people.integration.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

/**
 * Integration TestSuit for {@link PersonService}
 *
 * @author Wiktor Religo
 * @since 18.06.2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceIntegrationTest {
	
	@Autowired
	private TeamService teamService;
	@Autowired
	private PersonService personService;
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void shouldAutowireUsedLayersImplementations() {
		assertThat(teamService).isNotNull();
		assertThat(personService).isNotNull();
	}
	
	@Test
	@Transactional
	public void shouldReturnNoAssignedPeople() {
		// given
		TeamDto teamDto = new TeamDto(null, "Byczki z Osiedla ", "local", "wawa", 6);
		Team team = teamService.createTeam(teamDto);
		List<PersonDto> personDtoList = returnPersonTestResource();
		List<Person> personList = new ArrayList<>();
		
		personDtoList.forEach(p -> {
			Person person = personService.addPerson(p);
			personList.add(person);
		});
		
		// when
		teamService.addPersonsToTeams(team.getId(), personList.get(0).getId());
		teamService.addPersonsToTeams(team.getId(), personList.get(1).getId());
		// extract the people resource
		List<Person> notAssignedPeople = new ModelMapper()
				.map(personService.findNotAssignedPeople(), new TypeToken<List<PersonDto>>() {
				}.getType());
		
		entityManager.flush();
		entityManager.clear();
		
		// then
		assertThat(team.getPersons()).hasSize(2);
		assertThat(personList.get(2).getTeams()).isEmpty();
		assertThat(personList).hasSize(3);
		
		// grab id of unassigned Person
		long personID = personList.get(2).getId();
		
		// id of unassigned Person does not exist in Team's set collection
		assertThat(team.getPersons()
				.stream()
				.filter(t -> t.getId() == personID)
				.count()).isEqualTo(0);
		
		// check exists of Person as notAssigned
		assertThat(notAssignedPeople).contains(personList.get(2));
		
		// check Person with assigned Team, does not on the unassigned list
		assertThat(notAssignedPeople).doesNotContain(personList.get(0));
	}
	
	/**
	 * Method prepares the resource for test
	 * 
	 * @return list of PersonDto
	 */
	private List<PersonDto> returnPersonTestResource() {
		PersonDto p1 = new PersonDto(null, "Janek", "Bucha", "email1@onet.com", "krakow", "Programing", "Developer");
		PersonDto p2 = new PersonDto(null, "Tomasz", "Nieprzydzielony", "email2@onet.com", "krakow", "Programing", "Developer");
		PersonDto p3 = new PersonDto(null, "Genowefa", "Przydzielona", "email22@onet.com", "krakow", "UI-Design", "Developer");
		return Arrays.asList(p1, p2, p3);
	}
}
