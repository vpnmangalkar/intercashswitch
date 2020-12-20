/**
 * 
 */
package com.finastra.intercashswitch.service;

import java.util.List;

import com.finastra.intercashswitch.dto.BankPaymentMethodDto;

/**
 * Bundles all CRUD APIs for Bank Payment Method Channel Details
 * 
 * @author Vipin.Mangalkar
 * 
 */
public interface BankPaymentMethodChannelService {

	List<BankPaymentMethodDto> getAll(String bankId);

	BankPaymentMethodDto add(BankPaymentMethodDto bankPaymentMethodDto);

	BankPaymentMethodDto update(BankPaymentMethodDto bankPaymentMethodDto);

	void delete(Long channelId);

	BankPaymentMethodDto findByBankIdAndPaymentMode(String bankId, String paymentMode);
	
	BankPaymentMethodDto getById(Long channelId);
}
