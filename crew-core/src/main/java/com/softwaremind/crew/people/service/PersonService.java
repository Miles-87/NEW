package com.softwaremind.crew.people.service;

import java.util.*;
import java.util.stream.Collectors;

import com.softwaremind.crew.common.CreateEntityException;
import com.softwaremind.crew.teams.model.TeamDto;
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
	public PersonService(PersonRepository personRepository, ModelMapper modelMapper) {
		this.personRepository = personRepository;
		this.modelMapper = modelMapper;
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
		personRepository.deleteById(id);
		return personOptional.map(p -> modelMapper.map(p, PersonDto.class));
	}
	
	/**
	 * This method create new person
	 *
	 * @param personDto
	 * @return
	 */
	public Person addPerson(PersonDto personDto) {
		Assert.notNull(personDto, "Object can't be null!");
		try {
			Assert.notNull(personDto.getFirstName());
			return personRepository.save(modelMapper.map(personDto, Person.class));
		} catch (Exception e) {
			throw new CreateEntityException(e);
		}
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
	
	public Map<PersonDto, Set<TeamDto>> peopelWithTeamsAssigned() {
		List<Person> people = personRepository.findAll().stream()
				.filter(p -> p.getTeams() != null && !p.getTeams().isEmpty()).collect(Collectors.toList());
		Map<PersonDto, Set<TeamDto>> m = new HashMap<>();
		people.forEach(p -> {
			m.put(modelMapper.map(p, PersonDto.class),
					p.getTeams().stream().map(t -> modelMapper.map(t, TeamDto.class)).collect(Collectors.toSet()));
		});
		return m;
	}
	
}