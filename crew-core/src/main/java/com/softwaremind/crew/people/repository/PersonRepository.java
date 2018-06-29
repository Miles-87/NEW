package com.softwaremind.crew.people.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.softwaremind.crew.people.model.Person;

/**
 * PersonRepository class as data storage layer
 *
 * @author Wktor Religo
 * @author Mateusz Michoński
 * @since 09.04.2018
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Query(value = "SELECT * FROM PERSON WHERE PERSON.ID NOT IN ( SELECT PERSON_ID  FROM PERSONS_TEAMS  )", nativeQuery = true)
	List<Person> findAllNotAssignedPeople();
	
	List<Person> findByTeamsNotEmpty();
	
}
