/**
 * 
 */
package com.finastra.intercashswitch.exception;

import org.springframework.http.HttpStatus;

/**
 * @author u722954
 *
 */
public class PaymentDetailsNotFoundException extends APIException {

	private static final long serialVersionUID = 1375168778991700273L;

	/**
	 * @param error
	 */
	public PaymentDetailsNotFoundException(String payId) {
		super(new ErrorDetails(HttpStatus.NOT_FOUND, "Payment details not found [pay id="+payId+"]", "Requested resource not found"));
	}

}
