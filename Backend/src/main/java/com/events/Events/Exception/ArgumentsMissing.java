package com.events.Events.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.PARTIAL_CONTENT)
public class ArgumentsMissing extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ArgumentsMissing(String message) {
		super(message);
	}

}
