package com.softwaremind.crew.people.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	@GetMapping("/persons")
	public List<PersonDto> findAll() {
		return personService.findAll();
	}
	
	/**
	 * Method returns an Person entity selected id
	 *
	 * @param id
	 * @return
	 */
	
	@GetMapping(value = "/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDto> getPersonById(@PathVariable long id) {
		return personService
				.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	/**
	 * Update person in database
	 *
	 * @param id
	 * @param personDto
	 * @return
	 */
	@PutMapping("/persons/{id}")
	public ResponseEntity<PersonDto> updateById(@PathVariable(value = "id") long id, @RequestBody PersonDto personDto) {
		try {
			personService.updatePersonById(id, personDto);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	/**
	 * Delete person from database
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/persons/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		try {
			personService.deleteById(id);
			return ResponseEntity.ok().body("{Deleted}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cant delete! Entity not exist");
		}
	}
	
	/**
	 * Add new person to database
	 *
	 * @param personDto
	 * @return
	 */
	@PostMapping("/persons")
	public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
		try {
			personService.createPerson(personDto);
			return ResponseEntity.ok(personDto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
