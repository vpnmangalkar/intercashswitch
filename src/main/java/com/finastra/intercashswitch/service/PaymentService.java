package com.finastra.intercashswitch.service;

import javax.validation.Valid;

import com.finastra.intercashswitch.dto.PaymentInitiationDto;
import com.finastra.intercashswitch.dto.PaymentStatusDto;
import com.finastra.intercashswitch.entity.PaymentStatus;

/**
 * @author Vipin.Mangalkar
 * 
 *         Payment Service - Bundled All Payment Status Operation
 *
 */
public interface PaymentService {
	/**
	 * Method to Initiate Payment
	 * 
	 * @param paymentInitiationDto
	 * @return <code>PayId</code> (Payment ReferenceId for the given transaction)
	 */
	String initiatePayment(PaymentInitiationDto paymentInitiationDto);

	/**
	 * Method to get Payment/Transaction Status
	 * 
	 * @param paymentInitiationId
	 * @return <code>Status</code> of the payment transaction
	 *         <ul>
	 *         <li>INITIATED</li>
	 *         <li>INPROCESS</li>
	 *         <li>SENTTOHOST</li>
	 *         <li>COMPLETED</li>
	 *         <li>FAILED</li>
	 *         </ul>
	 * 
	 *         Link @{PaymentStatusDto}
	 */
	PaymentStatusDto getPaymentStatus(String paymentId);

	/**
	 * @param paymentStatusDto
	 * @return
	 */
	PaymentStatusDto update(@Valid PaymentStatusDto paymentStatusDto);
}
