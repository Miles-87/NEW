package com.softwaremind.crew.people.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.softwaremind.crew.people.model.Person;

/**
 * PersonRepository class as data storage layer
 * 
 * @author Wiktor Religo
 * @since 10.04.2018
 */
@Repository
public class PersonRepository {
	
	private final List<Person> personList = new ArrayList<>();
	
	/**
	 * Method initialize list of Person entity
	 */
	@PostConstruct
	private void initPeople() {
		personList.add(new Person(1, "Wiktor", "Pietrzyk", "Kraków", "email@gmail.com", "IT", "Developer"));
		personList.add(new Person(2, "Tomasz", "Nowak", "Kraków", "email2@gmail.com", "Quality", "UX Designer"));
		personList.add(new Person(3, "Katarzyna", "Janosik", "Radom", "email3@gmail.com", "BHP", "Manager"));
		personList.add(new Person(4, "Anna", "Lewacka", "Radom", "email3@gmail.com", "BHP", "Manager"));
		personList.add(new Person(5, "Janusz", "Górski", "Warszawa", "email4@gmail.com", "IT", "Developer"));
		personList.add(new Person(6, "Tomasz", "Drobny", "Warszawa", "email5@gmail.com", "Administration", "Accountant"));
		personList.add(new Person(7, "Mateusz", "Trybut", "Kraków", "email6@gmail.com", "Finance", ""));
		personList.add(new Person(8, "Marek", "Lesiński", "Poznań", "email7@gmail.com", "IT", "Developer"));
		personList.add(new Person(9, "Paweł", "Apostolski", "Poznań", "email8@gmail.com", "Finance", "Analyst"));
		personList.add(new Person(10, "Jan", "Kowalski", "Gdańsk", "email9@gmail.com", "Marketing", "Specialist"));
		personList.add(new Person(11, "Karolina", "Wójcik", "Sopot", "email10@gmail.com", "IT", "Developer"));
		personList.add(new Person(12, "Ewelina", "Marczyńska", "Gdynia", "email11@gmail.com", "BHP", "Specialist"));
		personList.add(new Person(13, "Anna", "Polowa", "Warszawa", "email12@gmail.com", "Marketing", "Manager"));
		personList.add(new Person(14, "Robert", "Kwaitkowski", "Rzeszów", "email13@gmail.com", "Administration", "Secretary"));
		personList.add(new Person(15, "Wojciech", "Norek", "Radom", "email14@gmail.com", "Finance", "Accountant"));
		personList.add(new Person(16, "Adam", "Jasiński", "Kraków", "email15@gmail.com", "Quality", "Engineer"));
	}
	
	/**
	 * Method returns all People as list
	 * 
	 * @return list of People
	 */
	public List<Person> getPeople() {
		return personList;
	}
}
