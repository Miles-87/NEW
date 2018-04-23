package com.softwaremind.crew.people.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwaremind.crew.people.model.Person;
import com.softwaremind.crew.people.model.dto.PersonDto;
import com.softwaremind.crew.people.service.PersonService;

/**
 * PersonRestController class for managing Persons
 *
 * @author Wiktor Religo
 * @author Mateusz Michoński
 * @since 09.04.2018
 */
@RestController
public class PersonRestController {
	
	private final PersonService personService;
	
	@Autowired
	public PersonRestController(PersonService personService) {
		this.personService = personService;
	}
	
	/**
	 * This method return all Persons
	 *
	 * @return
	 */
	@RequestMapping("/people")
	public List<PersonDto> findAll() {
		return personService.findAll();
	}
	
	/**
	 * Method returns an Person entity selected id
	 *
	 * @param id
	 * @return
	 */
	
	@GetMapping(value = "/people/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getPersonById(@PathVariable long id) {
		return personService.getPersonById(id);
	}
	
}
