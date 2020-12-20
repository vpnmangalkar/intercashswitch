/**
 * 
 */
package com.finastra.intercashswitch.service;

import java.util.List;

import com.finastra.intercashswitch.dto.BankDetailsDto;
import com.finastra.intercashswitch.dto.NostroAccountDetailsDto;

/**
 * Bundles all CRUD APIs for Bank Settlement Account
 * 
 * @author Vipin.Mangalkar
 * 
 */
public interface NostroAccountDetailsService {
	
	List<BankDetailsDto> getAll();
	
	NostroAccountDetailsDto getById(String accountId);

	NostroAccountDetailsDto add(NostroAccountDetailsDto nostroAccountDetailsDto);

	NostroAccountDetailsDto update(NostroAccountDetailsDto nostroAccountDetailsDto);

	void delete(String accountId);
}
