/**
 * 
 */
package com.finastra.intercashswitch.exception;

import org.springframework.http.HttpStatus;

/**
 * @author u722954
 *
 */
public class BankDetailsNotFoundException extends APIException {

	private static final long serialVersionUID = 2205371090223481134L;

	/**
	 * @param error
	 */
	public BankDetailsNotFoundException(String bankId) {
		super(new ErrorDetails(HttpStatus.NOT_FOUND, "Bank details not found [bank id="+bankId+"]", "Requested resource not found"));
	}

	/**
	 * @param error
	 */
	public BankDetailsNotFoundException(String swiftCode, String bicCode) {
		super(new ErrorDetails(HttpStatus.NOT_FOUND, "Bank details not found [swiftCode="+swiftCode+", bicCode="+bicCode+"]", "Requested resource not found"));
	}
}
