package com.finastra.intercashswitch.exception;

import org.springframework.http.HttpStatus;

/**
 * @author u722954
 *
 */
public class BankDetailsAlreadyExistException extends APIException {

	private static final long serialVersionUID = 5905314289280453409L;

	/**
	 * @param error
	 */
	public BankDetailsAlreadyExistException(String bankId) {
		super(new ErrorDetails(HttpStatus.IM_USED, "Bank details already exist. [bank id=" + bankId + "]",
				"Unable to create duplicate resource"));
	}

	/**
	 * @param swiftCode
	 * @param bicCode
	 */
	public BankDetailsAlreadyExistException(String swiftCode, String bicCode) {
		super(new ErrorDetails(HttpStatus.IM_USED,
				"Bank details already exist. [swiftCode=" + swiftCode + ", bicCode = " + bicCode + "]",
				"Unable to create duplicate resource"));
	}

}
