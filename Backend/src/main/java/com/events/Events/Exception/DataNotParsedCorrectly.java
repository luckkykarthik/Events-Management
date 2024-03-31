package com.events.Events.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_GATEWAY)
public class DataNotParsedCorrectly extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public DataNotParsedCorrectly(String message) {
		super(message);
	}

}
