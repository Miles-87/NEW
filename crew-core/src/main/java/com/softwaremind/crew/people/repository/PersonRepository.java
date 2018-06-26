package com.softwaremind.crew.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwaremind.crew.people.model.Person;

import java.util.List;

/**
 * PersonRepository class as data storage layer
 *
 * @author Wktor Religo
 * @author Mateusz Michoński
 * @since 09.04.2018
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	List<Person> findByTeamsNotEmpty();
}
