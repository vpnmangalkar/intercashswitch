/**
 * 
 */
package com.finastra.intercashswitch.service;

import java.util.List;

import com.finastra.intercashswitch.dto.BankDetailsDto;

/**
 * Bundles all CRUD APIs for Bank Details
 * 
 * @author Vipin.Mangalkar
 * 
 */
public interface BankDetailsService {

	List<BankDetailsDto> getAll();
	
	BankDetailsDto getByBankId(String bankId);

	BankDetailsDto add(BankDetailsDto bankDetailsDto);

	BankDetailsDto update(BankDetailsDto bankDetailsDto);

	void delete(String bankId);
}
