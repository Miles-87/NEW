package com.softwaremind.crew.teams.service;

/**
 * /**
 * This class is used to handle own Exception of the lack of entity in the database
 *
 * @author Wiktor Religo
 * @since 08.05.2018
 */
public class NoEntityFoundException extends RuntimeException {
	public NoEntityFoundException() {
		super("There is no Entity in database with given id.");
	}
	
}
