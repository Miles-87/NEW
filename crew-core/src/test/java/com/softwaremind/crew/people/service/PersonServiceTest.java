package com.softwaremind.crew.people.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.softwaremind.crew.people.model.Person;
import com.softwaremind.crew.people.model.dto.PersonDto;
import com.softwaremind.crew.people.repository.PersonRepository;

/**
 * TestSuit for {@link PersonService}
 *
 * @author Wiktor Religo
 * @author Mateusz Michoński
 * @since 10.04.2018
 */

public class PersonServiceTest {
	
	private PersonService personService;
	
	@Mock
	private PersonRepository personRepository;
	
	@Before
	public void initTest() {
		MockitoAnnotations.initMocks(this);
		personService = new PersonService(personRepository);
	}
	
	@Before
	public void initMockRepository() {
		Person person1 = new Person(1L, "jan", "mucha", "krakow", "email1@onet.com", "Programing", "Developer");
		Person person2 = new Person(3L, "Alicja", "Kowalska", "Warszawa", "email2@gmail.com", "Business", "Designer");
		Mockito.when(personRepository.findAll()).thenReturn(Arrays.asList(person1, person2));
	}
	
	@Test
	public void shouldReturnAllPeople() {
		
		List<PersonDto> resultPeopleDtos = personService.findAll();
		assertThat(resultPeopleDtos).hasSize(2);
	}
	
	@Test
	public void shouldReturnPersonById() {
		
		Optional<PersonDto> result = personService.findById(3L);
		assertThat(result).isNotNull();
	}
	
}