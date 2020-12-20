package com.finastra.intercashswitch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finastra.intercashswitch.dao.BankDetailsAuditRepository;
import com.finastra.intercashswitch.dao.BankDetailsRepository;
import com.finastra.intercashswitch.dto.BankDetailsDto;
import com.finastra.intercashswitch.entity.BankDetails;
import com.finastra.intercashswitch.entity.BankDetailsAudit;
import com.finastra.intercashswitch.entity.Status;
import com.finastra.intercashswitch.exception.BankDetailsAlreadyExistException;
import com.finastra.intercashswitch.exception.BankDetailsNotFoundException;
import com.finastra.intercashswitch.modelmapper.BankDetailsMapper;

/**
 * @author Vipin.Mangalkar Service - All Bank Details CURD Operation
 */
@Service
public class BankDetailsServiceImpl implements BankDetailsService {

	@Autowired
	private BankDetailsRepository bankDetailsRepository;

	@Autowired
	private BankDetailsAuditRepository bankDetailsAuditRepository;

	@Autowired
	private BankDetailsMapper bankDetailsMapper;

	@Override
	public List<BankDetailsDto> getAll() {
		List<BankDetails> bankList = bankDetailsRepository.findAll();
		return bankDetailsMapper.convertToDtos(bankList);
	}

	@Transactional(readOnly = true)
	@Override
	public BankDetailsDto getByBankId(String bankId) {
		BankDetails bankDetails = bankDetailsRepository.findById(bankId)
				.orElseThrow(() -> new BankDetailsNotFoundException(bankId));
		return bankDetailsMapper.convertToDto(bankDetails);
	}

	@Transactional
	@Override
	public BankDetailsDto add(BankDetailsDto bankDetailsDto) {

		// check if same id details are already present then through exception
		Optional<BankDetails> bankDetailsByCode = bankDetailsRepository.findBySwiftCodeOrBicCode(bankDetailsDto.getSwiftCode(), bankDetailsDto.getBicCode());
		
		if(bankDetailsByCode.isPresent())
			throw new BankDetailsAlreadyExistException(bankDetailsDto.getSwiftCode(), bankDetailsDto.getBicCode());

				
		BankDetails bankDetails = bankDetailsMapper.convertToEntity(bankDetailsDto);
		bankDetails = bankDetailsRepository.saveAndFlush(bankDetails);

		// audit request
		bankDetailsAuditRepository.save(new BankDetailsAudit(bankDetails, Status.CREATED, "SYSTEM"));

		return bankDetailsMapper.convertToDto(bankDetails);
	}

	@Transactional
	@Override
	public BankDetailsDto update(BankDetailsDto bankDetailsDto) {

		if (!bankDetailsRepository.existsById(bankDetailsDto.getBankId()))
			throw new BankDetailsNotFoundException(bankDetailsDto.getBankId());

		BankDetails bankDetails = bankDetailsMapper.convertToEntity(bankDetailsDto);
		bankDetails = bankDetailsRepository.saveAndFlush(bankDetails);

		// audit request
		bankDetailsAuditRepository.save(new BankDetailsAudit(bankDetails, Status.UPDATED, "SYSTEM"));

		return bankDetailsMapper.convertToDto(bankDetails);
	}

	@Transactional
	@Override
	public void delete(String bankId) {

		BankDetails bankDetails = bankDetailsRepository.findById(bankId)
				.orElseThrow(() -> new BankDetailsNotFoundException(bankId));

		// audit request
		bankDetailsAuditRepository.save(new BankDetailsAudit(bankDetails, Status.DELETED, "SYSTEM"));

		bankDetailsRepository.delete(bankDetails);
	}

}
