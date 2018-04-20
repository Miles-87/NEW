package com.softwaremind.crew.people.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping("/persons")
	public List<PersonDto> findAll() {
		List<PersonDto> allPersons = personService.findAll();
		for (PersonDto personDto : allPersons) {
			Person person = personService.mapDtoToTeamEntity(personDto);
			personService.mapPersonToPersonDto(person);
		}
		return allPersons;
	}
	
}
