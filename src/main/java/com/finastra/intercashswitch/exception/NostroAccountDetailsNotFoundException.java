package com.finastra.intercashswitch.exception;

import org.springframework.http.HttpStatus;

/**
 * @author u722954
 *
 */
public class NostroAccountDetailsNotFoundException extends APIException {

	private static final long serialVersionUID = 1730111643503719204L;

	/**
	 * @param error
	 */
	public NostroAccountDetailsNotFoundException(String accountId) {
		super(new ErrorDetails(HttpStatus.NOT_FOUND, "Bank Settlement Account details not found [account id="+accountId+"]", "Requested resource not found"));
	}
}
