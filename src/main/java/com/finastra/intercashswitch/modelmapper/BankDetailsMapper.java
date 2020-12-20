package com.finastra.intercashswitch.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finastra.intercashswitch.dto.BankDetailsDto;
import com.finastra.intercashswitch.entity.BankDetails;

/**
 * BankDetails Mapper to map {@link BankDetailsDto} to {@link BankDetails} and vice-versa
 *
 * @author Vipin.Mangalkar
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class BankDetailsMapper {

	@Autowired
    private ModelMapper modelMapper;
	
	/**
     * Convert {@link BankDetails} to {@link BankDetailsDto}
     *
     * @param bankDetails
     * @return {@link BankDetailsDto}
     */
    public BankDetailsDto convertToDto(BankDetails bankDetails) {
        return modelMapper.map(bankDetails, BankDetailsDto.class);
    }

    /**
     * Convert {@link BankDetailsDto} to {@link BankDetails}
     *
     * @param bankDetailsDto
     * @return {@link BankDetails}
     */
    public BankDetails convertToEntity(BankDetailsDto bankDetailsDto) {
        return modelMapper.map(bankDetailsDto, BankDetails.class);
    }

    /**
     * Convert List of {@link BankDetails} to List of {@link BankDetailsDto}
     *
     * @param claims
     * @return
     */
    public List<BankDetailsDto> convertToDtos(List<BankDetails> banks) {
        return banks.stream().map(bankDetails -> convertToDto(bankDetails)).collect(Collectors.toList());
    }

    /**
     * Merge {@link BankDetailsDto} with {@link BankDetails}
     *
     * @param bankDetailsDto
     * @param bankDetails
     */
    public void mergeToEntity(BankDetailsDto bankDetailsDto, BankDetails bankDetails) {
        modelMapper.map(bankDetailsDto, bankDetails);
    }

    public BankDetailsDto convertToBankDetailsDto(BankDetails bankDetails) {
        return modelMapper.map(bankDetails, BankDetailsDto.class);
    }

}
