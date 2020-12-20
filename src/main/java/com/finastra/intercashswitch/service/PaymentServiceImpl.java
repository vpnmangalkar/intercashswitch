package com.finastra.intercashswitch.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finastra.intercashswitch.constant.PaymentConstant;
import com.finastra.intercashswitch.dao.BankDetailsRepository;
import com.finastra.intercashswitch.dao.PaymentInitiationRepository;
import com.finastra.intercashswitch.dao.PaymentStatusRepository;
import com.finastra.intercashswitch.dto.PaymentInitiationDto;
import com.finastra.intercashswitch.dto.PaymentStatusDto;
import com.finastra.intercashswitch.entity.BankDetails;
import com.finastra.intercashswitch.entity.PaymentInitiation;
import com.finastra.intercashswitch.entity.PaymentStatus;
import com.finastra.intercashswitch.exception.BankDetailsNotFoundException;
import com.finastra.intercashswitch.exception.PaymentDetailsNotFoundException;
import com.finastra.intercashswitch.modelmapper.PaymentInitiationMapper;
import com.finastra.intercashswitch.modelmapper.PaymentStatusMapper;

/**
 * @author Vipin.Mangalkar Implementation Class of Payment Service
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentInitiationRepository paymentInitiationRepository;

	@Autowired
	private PaymentInitiationMapper paymentInitiationMapper;

	@Autowired
	private BankDetailsRepository bankDetailsRepository;

	@Autowired
	private PaymentStatusRepository paymentStatusRepository;

	@Autowired
	private PaymentStatusMapper paymentStatusMapper;

	@Transactional
	@Override
	public String initiatePayment(PaymentInitiationDto paymentInitiationDto) {

		PaymentInitiation paymentInitiation = paymentInitiationMapper.convertToEntity(paymentInitiationDto);

		paymentInitiation.setStatus(PaymentConstant.INITIATED);

		Optional<BankDetails> originatingBank = bankDetailsRepository.findBySwiftCodeOrBicCode(paymentInitiationDto.getOriginatingEntitySwift(), paymentInitiationDto.getOriginatingEntityBic());

		if (!originatingBank.isPresent())
			throw new BankDetailsNotFoundException(paymentInitiationDto.getOriginatingEntitySwift(), paymentInitiationDto.getOriginatingEntityBic());

		Optional<BankDetails> recipientBank = bankDetailsRepository.findBySwiftCodeOrBicCode(paymentInitiationDto.getRecipientEntitySwift(), paymentInitiationDto.getRecipientEntityBic());

		if (!recipientBank.isPresent())
			throw new BankDetailsNotFoundException(paymentInitiationDto.getOriginatingEntitySwift(), paymentInitiationDto.getOriginatingEntityBic());

		paymentInitiation.setFromBankId(originatingBank.get().getBankId()); // set from bank id

		paymentInitiation.setOriginatingEntityBankId(originatingBank.get().getBankId()); // set originating bank id

		paymentInitiation.setRecipientEntityBankId(recipientBank.get().getBankId()); // set originating bank id

		paymentInitiation = paymentInitiationRepository.saveAndFlush(paymentInitiation);

		paymentStatusRepository.save(new PaymentStatus(paymentInitiation.getPayId(), paymentInitiation.getStatus()));

		return paymentInitiation.getPayId();
	}

	@Transactional(readOnly = true)
	@Override
	public PaymentStatusDto getPaymentStatus(String paymentInitiationId) {

		Optional<PaymentInitiation> paymentDetails = paymentInitiationRepository.findById(paymentInitiationId);

		if (!paymentDetails.isPresent())
			throw new PaymentDetailsNotFoundException(paymentInitiationId);

		List<PaymentStatus> paymentStatusList = paymentStatusRepository.findByPayId(paymentInitiationId);

		return paymentStatusMapper.convertToPaymentStatusDto(paymentStatusList.get(paymentStatusList.size() - 1));
	}

	@Override
	public PaymentStatusDto update(@Valid PaymentStatusDto paymentStatusDto) {
		
		Optional<PaymentInitiation> paymentDetails = paymentInitiationRepository.findById(paymentStatusDto.getPayId());

		if (!paymentDetails.isPresent())
			throw new PaymentDetailsNotFoundException(paymentStatusDto.getPayId());
		
		List<PaymentStatus> paymentStatusList = paymentStatusRepository.findByPayId(paymentStatusDto.getPayId());
		
		PaymentStatus paymentStatus = paymentStatusList.get(paymentStatusList.size() - 1);
		
		paymentStatusDto.setSerialId(paymentStatus.getSerialId() + 1);
		
		paymentStatusRepository.saveAndFlush(paymentStatusMapper.convertToEntity(paymentStatusDto));
		
		return paymentStatusDto;
	}

}
