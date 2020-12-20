package com.finastra.intercashswitch.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finastra.intercashswitch.dto.PaymentInitiationDto;
import com.finastra.intercashswitch.entity.PaymentInitiation;

/**
 * PaymentInitiation Mapper to map {@link PaymentInitiationDto} to
 * {@link PaymentInitiation} and vice-versa
 *
 * @author Vipin.Mangalkar
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class PaymentInitiationMapper {

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Convert {@link PaymentInitiation} to {@link PaymentInitiationDto}
	 *
	 * @param paymentInitiation
	 * @return {@link PaymentInitiationDto}
	 */
	public PaymentInitiationDto convertToDto(PaymentInitiation paymentInitiation) {
		return modelMapper.map(paymentInitiation, PaymentInitiationDto.class);
	}

	/**
	 * Convert {@link PaymentInitiationDto} to {@link PaymentInitiation}
	 *
	 * @param paymentInitiationDto
	 * @return {@link PaymentInitiation}
	 */
	public PaymentInitiation convertToEntity(PaymentInitiationDto paymentInitiationDto) {
		return modelMapper.map(paymentInitiationDto, PaymentInitiation.class);
	}

	/**
	 * Convert List of {@link PaymentInitiation} to List of
	 * {@link PaymentInitiationDto}
	 *
	 * @param claims
	 * @return
	 */
	public List<PaymentInitiationDto> convertToDtos(List<PaymentInitiation> banks) {
		return banks.stream().map(paymentInitiation -> convertToDto(paymentInitiation)).collect(Collectors.toList());
	}

	/**
	 * Merge {@link PaymentInitiationDto} with {@link PaymentInitiation}
	 *
	 * @param paymentInitiationDto
	 * @param paymentInitiation
	 */
	public void mergeToEntity(PaymentInitiationDto paymentInitiationDto, PaymentInitiation paymentInitiation) {
		modelMapper.map(paymentInitiationDto, paymentInitiation);
	}

	public PaymentInitiationDto convertToPaymentInitiationDto(PaymentInitiation paymentInitiation) {
		return modelMapper.map(paymentInitiation, PaymentInitiationDto.class);
	}

}
