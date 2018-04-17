package com.softwaremind.crew.people.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.softwaremind.crew.people.model.Person;
import com.softwaremind.crew.people.repository.PersonRepository;

/**
 * TestSuit for {@link PersonService}
 *
 * @author Wiktor Religo
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
	
	@Test
	public void shouldReturnAllPeople() {
		initMockRepositoryToTest();
		
		List<Person> resultPeople = personService.findAll();
		assertThat(resultPeople).hasSize(2);
	}
	
	@Test
	public void shouldReturnPersonById() {
		initMockRepositoryToTest();
		
		Person result = personService.getPersonById(3l);
		assertThat(result).isNotNull();
		assertThat(result).hasFieldOrPropertyWithValue("id", 3l);
	}
	
	private void initMockRepositoryToTest() {
		Person person1 = new Person(1, "Tomek", "Nowak", "Krkaów", "email@gmail.com", "APPS", "Developer");
		Person person2 = new Person(3, "Alicja", "Kowalska", "Warszawa", "email2@gmail.com", "Business", "Designer");
		Mockito.when(personRepository.getPeople()).thenReturn(Arrays.asList(person1, person2));
	}
}