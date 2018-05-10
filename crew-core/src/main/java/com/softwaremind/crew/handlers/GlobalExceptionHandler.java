package com.softwaremind.crew.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.softwaremind.crew.teams.service.CreateEntityException;
import com.softwaremind.crew.teams.service.NoEntityFoundException;

/**
 * GlobalExceptionHandler class
 *
 * @author Wiktor Religo
 * @since 10.05.2018
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
		
		return handleExceptionInternal(ex, new BodyErrorInformation(ex.getMessage(), ex.getCause().getMessage()),
				new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(NoEntityFoundException.class)
	public ResponseEntity<Object> handleNoEntityFoundException(NoEntityFoundException ex, WebRequest request) {
		return handleExceptionInternal(ex, new BodyErrorInformation(ex.getMessage(), ex.getRestMethod()),
				new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(CreateEntityException.class)
	public ResponseEntity<Object> handleCreateEntityExcetpion(CreateEntityException ex, WebRequest request) {
		return handleExceptionInternal(ex, new BodyErrorInformation(ex.getMessage(), ex.getRestMethod()),
				new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	/**
	 * BodyErrorInformation class is used to holding output information about an Error
	 */
	private class BodyErrorInformation {
		private String error;
		private String restMethod;
		
		public BodyErrorInformation(String error, String method) {
			this.error = error;
			this.restMethod = method;
		}
		
		public String getError() {
			return error;
		}
		
		public void setError(String error) {
			this.error = error;
		}
		
		public String getRestMethod() {
			return restMethod;
		}
		
		public void setRestMethod(String restMethod) {
			this.restMethod = restMethod;
		}
	}
}
