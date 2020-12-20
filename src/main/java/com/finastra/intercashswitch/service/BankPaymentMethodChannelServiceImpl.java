package com.finastra.intercashswitch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finastra.intercashswitch.dao.BankDetailsRepository;
import com.finastra.intercashswitch.dao.BankPaymentMethodChannelRepository;
import com.finastra.intercashswitch.dto.BankPaymentMethodDto;
import com.finastra.intercashswitch.entity.BankDetails;
import com.finastra.intercashswitch.entity.BankPaymentMethod;
import com.finastra.intercashswitch.exception.BankDetailsNotFoundException;
import com.finastra.intercashswitch.exception.BankPaymentChannelDetailsNotFoundException;
import com.finastra.intercashswitch.modelmapper.BankPaymentMethodChannelMapper;

/**
 * Bundles all CRUD APIs for Bank Payment Method Channel Details
 * 
 * @author Vipin.Mangalkar
 * 
 */
@Service
public class BankPaymentMethodChannelServiceImpl implements BankPaymentMethodChannelService {

	@Autowired
	private BankPaymentMethodChannelRepository bankPaymentMethodChannelRepository;

	@Autowired
	private BankDetailsRepository bankDetailsRepository;
	
	@Autowired
	private BankPaymentMethodChannelMapper bankPaymentMethodChannelMapper;

	@Override
	public List<BankPaymentMethodDto> getAll(String bankId) {
		List<BankPaymentMethod> list = bankPaymentMethodChannelRepository.findByBankId(bankId);
		return bankPaymentMethodChannelMapper.convertToDtos(list);
	}

	@Transactional(readOnly = true)
	@Override
	public BankPaymentMethodDto findByBankIdAndPaymentMode(String bankId, String paymentMode) {
		BankPaymentMethod bankPaymentMethod = bankPaymentMethodChannelRepository
				.findByBankIdAndPaymentMode(bankId, paymentMode);

		return bankPaymentMethodChannelMapper.convertToBankPaymentMethodChannelDto(bankPaymentMethod);
	}

	@Transactional
	@Override
	public BankPaymentMethodDto add(BankPaymentMethodDto bankPaymentMethodDto) {
		
		// check bank details
		Optional<BankDetails> bankDetails = bankDetailsRepository.findById(bankPaymentMethodDto.getBankId());

		if (!bankDetails.isPresent())
			throw new BankDetailsNotFoundException(bankPaymentMethodDto.getBankId());
				
				
		BankPaymentMethod bankPaymentMethod = bankPaymentMethodChannelMapper
				.convertToEntity(bankPaymentMethodDto);
		bankPaymentMethod = bankPaymentMethodChannelRepository.saveAndFlush(bankPaymentMethod);

		// audit request
		return bankPaymentMethodChannelMapper.convertToDto(bankPaymentMethod);
	}

	@Transactional
	@Override
	public BankPaymentMethodDto update(BankPaymentMethodDto bankPaymentMethodDto) {

		if (!bankPaymentMethodChannelRepository.existsById(bankPaymentMethodDto.getPaymentMethodId()))
			throw new BankPaymentChannelDetailsNotFoundException(bankPaymentMethodDto.getPaymentMethodId());

		BankPaymentMethod bankPaymentMethod = bankPaymentMethodChannelMapper
				.convertToEntity(bankPaymentMethodDto);
		bankPaymentMethod = bankPaymentMethodChannelRepository.saveAndFlush(bankPaymentMethod);

		// audit request

		return bankPaymentMethodChannelMapper.convertToDto(bankPaymentMethod);
	}

	@Transactional
	@Override
	public void delete(Long paymentMethodId) {

		BankPaymentMethod bankPaymentMethod = bankPaymentMethodChannelRepository.findById(paymentMethodId)
				.orElseThrow(() -> new BankPaymentChannelDetailsNotFoundException(paymentMethodId));

		// audit request

		bankPaymentMethodChannelRepository.delete(bankPaymentMethod);
	}

	@Transactional(readOnly = true)
	@Override
	public BankPaymentMethodDto getById(Long paymentMethodId) {
		BankPaymentMethod bankPaymentMethod = bankPaymentMethodChannelRepository.findById(paymentMethodId)
				.orElseThrow(() -> new BankPaymentChannelDetailsNotFoundException(paymentMethodId));
		return bankPaymentMethodChannelMapper.convertToDto(bankPaymentMethod);
	}
	
}
