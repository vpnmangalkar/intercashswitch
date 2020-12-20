package com.finastra.intercashswitch.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finastra.intercashswitch.dto.BankPaymentMethodDto;
import com.finastra.intercashswitch.entity.BankPaymentMethod;

/**
 * BankPaymentMethodChannel Mapper to map {@link BankPaymentMethodDto} to
 * {@link BankPaymentMethod} and vice-versa
 *
 * @author Vipin.Mangalkar
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class BankPaymentMethodChannelMapper {

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Convert {@link BankPaymentMethod} to
	 * {@link BankPaymentMethodDto}
	 *
	 * @param BankPaymentMethod
	 * @return {@link BankPaymentMethodDto}
	 */
	public BankPaymentMethodDto convertToDto(BankPaymentMethod bankPaymentMethod) {
		return modelMapper.map(bankPaymentMethod, BankPaymentMethodDto.class);
	}

	/**
	 * Convert {@link BankPaymentMethodDto} to
	 * {@link BankPaymentMethod}
	 *
	 * @param bankPaymentMethodDto
	 * @return {@link BankPaymentMethod}
	 */
	public BankPaymentMethod convertToEntity(BankPaymentMethodDto bankPaymentMethodDto) {
		return modelMapper.map(bankPaymentMethodDto, BankPaymentMethod.class);
	}

	/**
	 * Convert List of {@link BankPaymentMethod} to List of
	 * {@link BankPaymentMethodDto}
	 *
	 * @param claims
	 * @return
	 */
	public List<BankPaymentMethodDto> convertToDtos(List<BankPaymentMethod> banks) {
		return banks.stream().map(bankPaymentMethodChannel -> convertToDto(bankPaymentMethodChannel))
				.collect(Collectors.toList());
	}

	/**
	 * Merge {@link BankPaymentMethodDto} with
	 * {@link BankPaymentMethod}
	 *
	 * @param bankPaymentMethodDto
	 * @param bankPaymentMethod
	 */
	public void mergeToEntity(BankPaymentMethodDto bankPaymentMethodDto,
			BankPaymentMethod bankPaymentMethod) {
		modelMapper.map(bankPaymentMethodDto, bankPaymentMethod);
	}

	public BankPaymentMethodDto convertToBankPaymentMethodChannelDto(
			BankPaymentMethod bankPaymentMethod) {
		return modelMapper.map(bankPaymentMethod, BankPaymentMethodDto.class);
	}

}
