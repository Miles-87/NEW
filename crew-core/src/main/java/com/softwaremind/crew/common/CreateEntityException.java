package com.softwaremind.crew.common;

/**
 * Class for handling exception on creating team data
 *
 * @author Wiktor Religo
 * @since 10.05.2018
 */
public class CreateEntityException extends RuntimeException {
	
	public CreateEntityException() {
		super("Creating new team - failed.There is an error with object fields");
	}
}
