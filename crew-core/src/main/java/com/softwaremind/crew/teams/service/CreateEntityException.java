package com.softwaremind.crew.teams.service;

/**
 * Class for handling exception on creating team data
 *
 * @author Wiktor Religo
 * @since 10.05.2018
 */
public class CreateEntityException extends RuntimeException {
	
	private String restMethod;
	
	public CreateEntityException(String method) {
		super("Creating new team - failed.There is an error with object fields");
		this.restMethod = method;
		
	}
	
	public CreateEntityException() {
		super("Creating new team - failed.There is an error with object fields");
	}
	
	public String getRestMethod() {
		return restMethod;
	}
}
