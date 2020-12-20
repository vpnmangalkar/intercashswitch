package com.finastra.intercashswitch.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Wrapper of error details that has to be sent in Api Response
 *
 * @author Vipin.Mangalkar
 */
@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
@Schema(description = "All details about the error.")
public class ErrorDetails {

	/**
	 * Http Status
	 */
	@Schema(description = "API Error Code")
	private int statusCode;
	
	@Schema(description = "API Error Status")
	private HttpStatus status;

	/**
	 * Service Error Message
	 */
	@Schema(description = "API Error Message")
	private String message;

	/**
	 * List of Error Messages
	 */
	@Schema(description = "API Errors List")
	private List<String> errors;

	/**
	 * 
	 */
	public ErrorDetails() {
	}

	public ErrorDetails(HttpStatus status, String message, List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public ErrorDetails(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

	@Override
	public String toString() {
		return String.format("%s-%s error-list:%s", status, message, errors);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
}
