package com.softwaremind.crew.people.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaremind.crew.people.model.Person;
import com.softwaremind.crew.people.repository.PersonRepository;

/**
 * PersonService class for managing {@link PersonRepository}
 * 
 * @author Wiktor Religo
 * @since 10.04.2018
 */
@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	/**
	 * Method returns all People
	 * 
	 * @return all People
	 */
	public List<Person> findAll() {
		return personRepository.getPeople();
	}
	
	/**
	 * Method returns an Person entity selected by id
	 * 
	 * @param id
	 *            of Person
	 * @return Person entity
	 */
	public Person getPersonById(long id) {
		
		return personRepository.getPeople()
				.stream()
				.filter(p -> p.getId() == id)
				.findAny().orElseThrow(NoSuchElementException::new);
		
	}
	
}
