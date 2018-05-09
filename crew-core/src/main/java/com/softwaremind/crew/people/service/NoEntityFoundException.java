package com.softwaremind.crew.people.service;

/**
 * Class check Exception of the lack of entity in the database
 * 
 * @author Mateusz Michoński
 * @since 08.05.2018
 */
public class NoEntityFoundException extends RuntimeException {
	public NoEntityFoundException() {
		super("There is no Entity in database with this id.");
	}
}