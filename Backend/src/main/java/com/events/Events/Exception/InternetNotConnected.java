package com.events.Events.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.SERVICE_UNAVAILABLE)
public class InternetNotConnected extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public InternetNotConnected(String message) {
		super(message);
	}
}