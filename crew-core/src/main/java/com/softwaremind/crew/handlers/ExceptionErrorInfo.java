package com.softwaremind.crew.handlers;

/**
 * ExceptionErrorInfo immutable class is used to holding output information about an Error
 * 
 * @author Wiktor Religo
 * @since 11.05.2018
 */
public final class ExceptionErrorInfo {
	private final String error;
	
	public ExceptionErrorInfo(String error) {
		this.error = error;
	}
	
	public String getError() {
		return error;
	}
}
