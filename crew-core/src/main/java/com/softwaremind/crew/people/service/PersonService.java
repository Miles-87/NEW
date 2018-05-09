package com.softwaremind.crew.people.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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
@Transactional
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
	public Optional<PersonDto> findById(Long id) {
		Assert.notNull(id, "id can't be null");
		return personRepository
				.findById(id)
				.map(p -> modelMapper.map(p, PersonDto.class));
		
	}
	
	/**
	 * This method delete person by id
	 *
	 * @param id
	 */
	public Optional<PersonDto> deletePerson(Long id) {
		Assert.notNull(id, "id can't be null");
		Optional<Person> personOptional = personRepository.findById(id);
		personRepository.delete(personOptional.orElse(new Person()));
		return personOptional.map(p -> modelMapper.map(p, PersonDto.class));
	}
	
	/**
	 * This method create new person
	 *
	 * @param personDto
	 * @return
	 */
	public Optional<PersonDto> addPerson(PersonDto personDto) {
		Assert.notNull(personDto, "personDto can't be null");
		Person person = personRepository
				.save(modelMapper.map(personDto, Person.class));
		return Optional.of(modelMapper.map(person, PersonDto.class));
	}
	
	/**
	 * This method update person by id
	 *
	 * @param id
	 * @param personDto
	 * @return
	 */
	
	public void updatePersonById(long id, PersonDto personDto) throws NoSuchElementException {
		Assert.notNull(id, "id can't be null");
		Assert.notNull(personDto, "personDto can't be null");
		personRepository.findById(id)
				.map(person -> {
					Person personEntity = personRepository.getOne(id);
					personEntity.setFirstName(personDto.getFirstName());
					personEntity.setLastName(personDto.getLastName());
					personEntity.setLocation(personDto.getLocation());
					personEntity.setEmail(personDto.getEmail());
					personEntity.setRole(personDto.getRole());
					personEntity.setStatus(personDto.getStatus());
					return personRepository.save(personEntity);
				}).orElseThrow(NoSuchElementException::new);
	}
	
}
