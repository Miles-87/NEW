package com.softwaremind.crew.people.service;

import java.util.List;
import java.util.Optional;

import com.softwaremind.crew.people.model.Person;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaremind.crew.people.model.dto.PersonDto;
import com.softwaremind.crew.people.repository.PersonRepository;

import javax.transaction.Transactional;

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
	public Optional<PersonDto> findById(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("id shouldn't be null");
		}
		return personRepository
				.findById(id)
				.map(p -> modelMapper.map(p, PersonDto.class));
		
	}
	
	/**
	 * This method delete person by id
	 *
	 * @param id
	 */
	@Transactional
	public void deleteById(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("id shouldn't be null");
		}
		personRepository.deleteById(id);
		
	}
	
	/**
	 * This method create new person
	 *
	 * @param personDto
	 * @return
	 */
	@Transactional
	public void createPerson(PersonDto personDto) {
		if (Optional.ofNullable(personDto).isPresent()) {
			personRepository.save(modelMapper.map(personDto, Person.class));
		} else {
			throw new IllegalArgumentException("insert correct argument");
		}
	}
	
	/**
	 * This method update person by id
	 *
	 * @param id
	 * @param personDto
	 * @return
	 */
	@Transactional
	public Optional<PersonDto> updatePersonById(long id, PersonDto personDto) {
		if (personRepository.findById(id).isPresent()) {
			Person personEntity = personRepository.getOne(id);
			personEntity.setFirstName(personDto.getFirstName());
			personEntity.setLastName(personDto.getLastName());
			personEntity.setLocation(personDto.getLocation());
			personEntity.setEmail(personDto.getEmail());
			personEntity.setRole(personDto.getRole());
			personEntity.setStatus(personDto.getStatus());
			personRepository.save(personEntity);
			return Optional.of(modelMapper.map(personEntity, PersonDto.class));
		} else {
			throw new IllegalArgumentException("No such entity in database with given ID  ");
		}
	}
	
}
