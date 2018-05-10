package com.softwaremind.crew.teams.service;

/**
 * This class is used to handle own Exception of the lack of entity in the database
 *
 * @author Wiktor Religo
 * @since 08.05.2018
 */
public class NoEntityFoundException extends RuntimeException {
	
	private String restMethod;
	
	public NoEntityFoundException(String method) {
		super("There is no Entity in database with given id.");
		this.restMethod = method;
		
	}
	
	public NoEntityFoundException() {
		super("There is no Entity in database with given id.");
	}
	
	public String getRestMethod() {
		return restMethod;
	}
}
