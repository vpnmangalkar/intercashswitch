package com.finastra.intercashswitch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Vipin.Mangalkar
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message message
	 * @see RuntimeException#RuntimeException(String)
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
