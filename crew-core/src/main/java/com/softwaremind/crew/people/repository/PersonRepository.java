package com.softwaremind.crew.people.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwaremind.crew.people.model.Person;

/**
 * PersonRepository class as data storage layer
 * 
 * @author Mateusz Michoński
 * @since 20.04.2018
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
