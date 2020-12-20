package com.finastra.intercashswitch.exception;

import org.springframework.http.HttpStatus;

/**
 * @author u722954
 *
 */
public class BankPaymentChannelDetailsNotFoundException extends APIException {

	private static final long serialVersionUID = 8021121038283884308L;

	/**
	 * @param error
	 */
	public BankPaymentChannelDetailsNotFoundException(Long channelId) {
		super(new ErrorDetails(HttpStatus.NOT_FOUND, "Bank Payment Channel details not found [channel id="+channelId+"]", "Requested resource not found"));
	}

}
