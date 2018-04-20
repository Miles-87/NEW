package com.softwaremind.crew.people.service;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaremind.crew.people.model.Person;
import com.softwaremind.crew.people.model.dto.PersonDto;
import com.softwaremind.crew.people.repository.PersonRepository;

/**
 * PersonService class for managing {@link PersonRepository}
 * 
 * @author Mateusz Michoński
 * @since 20.04.2018
 */
@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	ModelMapper modelMapper = new ModelMapper();
	
	/**
	 * This method mapped from person to person DTO
	 *
	 * @author Mateusz Michoński
	 * @since 20.04.2018
	 */
	public void mappedPersonToPersonDto() {
		Person person1 =
				new Person("Jan", "mucha", "dfs", "sdfsdf", "sdfsd", "d33", LocalDate.parse("12-02-2015"), LocalDate.parse("12-02-2016"));
		PersonDto personDto = modelMapper.map(person1, PersonDto.class);
		
	}
	
}
