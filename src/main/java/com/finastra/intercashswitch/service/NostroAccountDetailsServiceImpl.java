package com.finastra.intercashswitch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finastra.intercashswitch.dao.BankDetailsRepository;
import com.finastra.intercashswitch.dao.NostroAccountDetailsRepository;
import com.finastra.intercashswitch.dto.BankDetailsDto;
import com.finastra.intercashswitch.dto.NostroAccountDetailsDto;
import com.finastra.intercashswitch.entity.BankDetails;
import com.finastra.intercashswitch.entity.NostroAccountDetails;
import com.finastra.intercashswitch.exception.BankDetailsNotFoundException;
import com.finastra.intercashswitch.exception.NostroAccountDetailsNotFoundException;
import com.finastra.intercashswitch.modelmapper.NostroAccountDetailsMapper;

/**
 * Bundles all CRUD APIs for Bank Settlement Account
 * 
 * @author Vipin.Mangalkar
 * 
 */
@Service
public class NostroAccountDetailsServiceImpl implements NostroAccountDetailsService {

	@Autowired
	private NostroAccountDetailsRepository nostroAccountDetailsRepository;

	@Autowired
	private NostroAccountDetailsMapper nostroAccountDetailsMapper;

	@Autowired
	private BankDetailsRepository bankDetailsRepository;

	@Override
	public List<BankDetailsDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public NostroAccountDetailsDto getById(String accountId) {

		NostroAccountDetails nostroAccountDetails = nostroAccountDetailsRepository.findById(accountId)
				.orElseThrow(() -> new NostroAccountDetailsNotFoundException(accountId));
		return nostroAccountDetailsMapper.convertToDto(nostroAccountDetails);
	}

	@Transactional
	@Override
	public NostroAccountDetailsDto add(NostroAccountDetailsDto nostroAccountDetailsDto) {

		NostroAccountDetails nostroAccountDetails = nostroAccountDetailsMapper
				.convertToEntity(nostroAccountDetailsDto);

		// get owner bank details from bank bic or swift code
		Optional<BankDetails> ownerBankDetails = bankDetailsRepository.findBySwiftCodeOrBicCode(
				nostroAccountDetails.getOwnerSwiftCode(), nostroAccountDetails.getOwnerBicCode());

		if (!ownerBankDetails.isPresent())
			throw new BankDetailsNotFoundException(nostroAccountDetails.getOwnerSwiftCode(),
					nostroAccountDetails.getOwnerBicCode());

		// get partner bank details from bank bic or swift code
		Optional<BankDetails> parterBankDetails = bankDetailsRepository.findBySwiftCodeOrBicCode(
				nostroAccountDetails.getPartnerSwiftCode(), nostroAccountDetails.getPartnerBicCode());

		if (!parterBankDetails.isPresent())
			throw new BankDetailsNotFoundException(nostroAccountDetails.getPartnerSwiftCode(),
					nostroAccountDetails.getPartnerBicCode());

		nostroAccountDetails.setOwnerBankId(ownerBankDetails.get().getBankId());
		nostroAccountDetails.setPartnerBankId(parterBankDetails.get().getBankId());

		nostroAccountDetails = nostroAccountDetailsRepository.saveAndFlush(nostroAccountDetails);

		return nostroAccountDetailsMapper.convertToDto(nostroAccountDetails);

		// TODO: audit add request
	}

	@Override
	public NostroAccountDetailsDto update(NostroAccountDetailsDto nostroAccountDetailsDto) {
		if (!nostroAccountDetailsRepository.existsById(nostroAccountDetailsDto.getAccountId()))
			throw new NostroAccountDetailsNotFoundException(nostroAccountDetailsDto.getAccountId());

		NostroAccountDetails nostroAccountDetails = nostroAccountDetailsMapper
				.convertToEntity(nostroAccountDetailsDto);
		nostroAccountDetailsRepository.saveAndFlush(nostroAccountDetails);

		// TODO: audit update request
		return nostroAccountDetailsMapper.convertToDto(nostroAccountDetails);
	}

	@Override
	public void delete(String accountId) {
		NostroAccountDetails nostroAccountDetails = nostroAccountDetailsRepository.findById(accountId)
				.orElseThrow(() -> new NostroAccountDetailsNotFoundException(accountId));

		// TODO: Audit Delete Request
		nostroAccountDetailsRepository.delete(nostroAccountDetails);

	}

}
