/**
 * 
 */
package com.finastra.intercashswitch.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finastra.intercashswitch.dto.NostroAccountDetailsDto;
import com.finastra.intercashswitch.entity.NostroAccountDetails;

/**
 * NostroAccountDetails Mapper to map {@link NostroAccountDetailsDto} to
 * {@link NostroAccountDetails} and vice-versa
 *
 * @author Vipin.Mangalkar
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class NostroAccountDetailsMapper {

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Convert {@link NostroAccountDetails} to
	 * {@link NostroAccountDetailsDto}
	 *
	 * @param nostroAccountDetails
	 * @return {@link NostroAccountDetailsDto}
	 */
	public NostroAccountDetailsDto convertToDto(NostroAccountDetails nostroAccountDetails) {
		return modelMapper.map(nostroAccountDetails, NostroAccountDetailsDto.class);
	}

	/**
	 * Convert {@link NostroAccountDetailsDto} to
	 * {@link NostroAccountDetails}
	 *
	 * @param nostroAccountDetailsDto
	 * @return {@link NostroAccountDetails}
	 */
	public NostroAccountDetails convertToEntity(NostroAccountDetailsDto nostroAccountDetailsDto) {
		return modelMapper.map(nostroAccountDetailsDto, NostroAccountDetails.class);
	}

	/**
	 * Convert List of {@link NostroAccountDetails} to List of
	 * {@link NostroAccountDetailsDto}
	 *
	 * @param claims
	 * @return
	 */
	public List<NostroAccountDetailsDto> convertToDtos(List<NostroAccountDetails> banks) {
		return banks.stream().map(settlementAccountDetails -> convertToDto(settlementAccountDetails))
				.collect(Collectors.toList());
	}

	/**
	 * Merge {@link NostroAccountDetailsDto} with
	 * {@link NostroAccountDetails}
	 *
	 * @param nostroAccountDetailsDto
	 * @param nostroAccountDetails
	 */
	public void mergeToEntity(NostroAccountDetailsDto nostroAccountDetailsDto,
			NostroAccountDetails nostroAccountDetails) {
		modelMapper.map(nostroAccountDetailsDto, nostroAccountDetails);
	}

	public NostroAccountDetailsDto convertToSettlementAccountDetailsDto(
			NostroAccountDetails nostroAccountDetails) {
		return modelMapper.map(nostroAccountDetails, NostroAccountDetailsDto.class);
	}
}
