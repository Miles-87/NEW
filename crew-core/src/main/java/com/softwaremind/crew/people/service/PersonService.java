package com.softwaremind.crew.people.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaremind.crew.people.model.Person;
import com.softwaremind.crew.people.model.dto.PersonDto;
import com.softwaremind.crew.people.repository.PersonRepository;

/**
 * PersonService class for managing {@link PersonRepository}
 *
 * @author Wiktor Religo
 * @author Mateusz Michoński
 * @since 09.04.2018
 */
@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
		this.modelMapper = new ModelMapper();
	}
	
	/**
	 * This method return a list of Persons
	 *
	 * @return
	 */
	public List<PersonDto> findAll() {
		return modelMapper.map(personRepository.findAll(), new TypeToken<List<PersonDto>>() {
		}.getType());
	}
	
	/**
	 * Method returns a Person by id
	 *
	 * @param id
	 * @return
	 */
	public Optional<Person> findOne(Long id) {
		if (id != null) {
			return personRepository
					.findById(id)
					.map(p -> modelMapper.map(p, Person.class));
		}
		return Optional.empty();
	}
}
