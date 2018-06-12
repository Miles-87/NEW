package com.softwaremind.crew.people.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.softwaremind.crew.people.model.Person;
import com.softwaremind.crew.people.model.dto.PersonDto;
import com.softwaremind.crew.people.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.softwaremind.crew.common.NoEntityFoundException;
import com.softwaremind.crew.teams.model.Team;
import com.softwaremind.crew.teams.model.TeamDto;
import com.softwaremind.crew.teams.repository.TeamRepository;
import com.softwaremind.crew.teams.service.TeamService;

/**
 * TestSuit for(@link TeamService)
 *
 * @author Mateusz Michoński
 * @author Wiktor Religo
 * @since 16.04.2018
 */
public class TeamServiceTest {
	private TeamService teamService;
	private ModelMapper mapper;
	private PersonService personService;
	
	@Mock
	private TeamRepository teamRepository;
	@Mock
	private PersonRepository personRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mapper = new ModelMapper();
		teamService = new TeamService(teamRepository,personRepository, this.mapper);
		personService = new PersonService(personRepository, this.mapper);
	}
	
	@Test
	public void shouldReturnAllTeams() {
		initMockServiceTest();
		
		List<TeamDto> resultTeamDtos = teamService.findAll();
		assertThat(resultTeamDtos)
				.extracting("name", "description", "city", "headcount")
				.contains(
						tuple("Name1", "description1", "city1", 2),
						tuple("Name2", "description2", "city2", 5));
	}
	
	@Test
	public void shouldReturnTeamById() {
		Team team1 = new Team(1l, "Name1", "description1", "city1", 2);
		
		when(teamRepository.findById(1l)).thenReturn(Optional.ofNullable(team1));
		Optional<TeamDto> teamById = teamService.findTeamById(1l);
		
		assertThat(teamById.get().getId()).isEqualTo(1l);
		assertThat(team1.getCity()).isEqualTo(teamById.get().getCity());
	}
	
	@Test
	public void shouldNotReturnTeamWithNoId() {
		when(teamRepository.findById(null)).thenThrow(new IllegalArgumentException("An argument is missing ! "));
		
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> teamService.findTeamById(null))
				.withMessage("ID must exist ");
	}
	
	@Test
	public void shouldNotReturnTeamByGivenId() {
		when(teamRepository.findById(2l)).thenReturn(Optional.empty());
		
		Optional<TeamDto> teamById = teamService.findTeamById(2l);
		
		assertThat(teamById).isEmpty();
	}
	
	@Test
	public void shouldAddTeamToDatabase() {
		Team team1 = new Team(1l, "Name1", "description1", "city1", 2);
		
		teamService.createTeam(mapper.map(team1, TeamDto.class));
		
		verify(teamRepository, times(1)).save(team1);
	}
	
	@Test
	public void shouldNotAddTeamToDatabase() {
		when(teamRepository.save(null)).thenThrow(new IllegalArgumentException());
		
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> teamService.createTeam(null))
				.withMessage("Object can't be null!");
	}
	
	@Test
	public void shouldDeleteTeamById() {
		teamService.deleteTeamById(1l);
		
		verify(teamRepository, times(1)).deleteById(1l);
	}
	
	@Test
	public void shouldNotDeleteTeamById() {
		doThrow(new IllegalArgumentException()).when(teamRepository).deleteById(null);
		
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> teamService.deleteTeamById(null))
				.withMessage("Id can't be null !");
	}
	
	@Test
	public void shouldNotDeleteWhenTeamNotExist() {
		doThrow(new IllegalStateException()).when(teamRepository).deleteById(11l);
		
		assertThatExceptionOfType(IllegalStateException.class)
				.isThrownBy(() -> teamService.deleteTeamById(11l))
				.withMessage("Team with given id, does not exist ! ");
	}
	
	@Test
	public void shouldUpdateTeamInDatabase() {
		Team team1 = new Team(1l, "Name1", "description1", "city1", 2);
		
		when(teamRepository.save(team1)).thenReturn(team1);
		when(teamRepository.findById(1l)).thenReturn(Optional.of(team1));
		when(teamRepository.getOne(1l)).thenReturn(team1);
		
		teamService.updateTeamById(1l, mapper.map(team1, TeamDto.class));
		
		verify(teamRepository, times(1)).save(team1);
		verify(teamRepository, times(1)).findById(1l);
		verify(teamRepository, times(1)).getOne(1l);
	}
	
	@Test
	public void shouldNotUpdateTeamToDatabase() {
		TeamDto teamDto = new TeamDto(1l, "TestCase1", "Description1", "Krakow", 12);
		
		when(teamRepository.findById(1l)).thenThrow(new NoEntityFoundException());
		when(teamRepository.findById(2l)).thenThrow(new IllegalArgumentException());
		when(teamRepository.findById(null)).thenThrow(new IllegalArgumentException());
		
		assertThatExceptionOfType(NoEntityFoundException.class)
				.isThrownBy(() -> teamService.updateTeamById(1l, teamDto))
				.withMessage("There is no Entity in database with given id.");
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> teamService.updateTeamById(null, teamDto))
				.withMessage("Id can't be null ! ");
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> teamService.updateTeamById(2l, null))
				.withMessage("Object can't be null!");
	}
	
	@Test
	public void shouldAddPersonToTeam() {
		Team team = new Team(1L, "TestCase1", "Description1", "Krakow", 12);
		Person person = new Person(1L, "jan", "mucha", "krakow", "email1@onet.com", "Programing", "Developer");
		
		doReturn(team).when(teamRepository).getOne(1L);
		doReturn(person).when(personRepository).getOne(1L);
		
		teamService.createTeam(mapper.map(team, TeamDto.class));
		personService.addPerson(mapper.map(person, PersonDto.class));
		teamService.addPersonsToTeams(team.getId(), person.getId());
		
		verify(teamRepository).save(team);
		verify(personRepository).save(person);
	}
	
	private void initMockServiceTest() {
		Team team1 = new Team(1l, "Name1", "description1", "city1", 2);
		Team team2 = new Team(1l, "Name2", "description2", "city2", 5);
		
		when(teamRepository.findAll()).thenReturn(Arrays.asList(team1, team2));
	}
}
