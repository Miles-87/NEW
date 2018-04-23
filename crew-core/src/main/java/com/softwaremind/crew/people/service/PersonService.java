package com.softwaremind.crew.people.service;

import java.util.Arrays;
import java.util.List;

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
	/**
	 * This method mapped from person to person DTO
	 *
	 * @author Mateusz Michoński
	 * @since 20.04.2018
	 */
	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public PersonDto mapPersonToPersonDto(Person person) {
		PersonDto personDto = modelMapper.map(person, PersonDto.class);
		return personDto;
	}
	
	public Person mapDtoToPersonEntity(PersonDto personDto) {
		Person person = modelMapper.map(personDto, Person.class);
		return person;
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
	
}
