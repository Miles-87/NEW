package com.softwaremind.crew.common;

/**
 * This class is used to handle own Exception of the lack of entity in the database
 *
 * @author Wiktor Religo
 * @author Mateusz Michoński
 * @since 08.05.2018
 */
public class NoEntityFoundException extends RuntimeException {
	
	public NoEntityFoundException() {
		super("There is no Entity in database with given id.");
	}

	public NoEntityFoundException(String message) {
		super(message);
	}

	public NoEntityFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoEntityFoundException(Throwable cause) {
		super(cause);
	}

	protected NoEntityFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
