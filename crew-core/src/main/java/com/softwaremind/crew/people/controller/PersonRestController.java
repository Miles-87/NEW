package com.softwaremind.crew.people.controller;

import java.util.LinkedList;
import java.util.List;

import com.softwaremind.crew.people.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.softwaremind.crew.people.model.Person;
import com.softwaremind.crew.people.service.PersonService;

/**
 * PersonRestController class for managing Persons
 *
 * @author Mateusz Michoński
 * @since 20.04.2018
 */
@RestController
public class PersonRestController {

	private PersonRepository personRepository;
	private final PersonService personService;
	
	@Autowired
	public PersonRestController(PersonService personService) {
		this.personService = personService;
	}


	
}
