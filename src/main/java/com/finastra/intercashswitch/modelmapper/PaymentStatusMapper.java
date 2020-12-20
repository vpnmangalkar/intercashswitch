package com.finastra.intercashswitch.modelmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finastra.intercashswitch.dto.PaymentStatusDto;
import com.finastra.intercashswitch.entity.PaymentStatus;

/**
 * PaymentStatus Mapper to map {@link PaymentStatusDto} to {@link PaymentStatus} and vice-versa
 *
 * @author Vipin.Mangalkar
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class PaymentStatusMapper {

	@Autowired
    private ModelMapper modelMapper;
	
	/**
     * Convert {@link PaymentStatus} to {@link PaymentStatusDto}
     *
     * @param paymentStatus
     * @return {@link PaymentStatusDto}
     */
    public PaymentStatusDto convertToDto(PaymentStatus paymentStatus) {
        return modelMapper.map(paymentStatus, PaymentStatusDto.class);
    }

    /**
     * Convert {@link PaymentStatusDto} to {@link PaymentStatus}
     *
     * @param paymentStatusDto
     * @return {@link PaymentStatus}
     */
    public PaymentStatus convertToEntity(PaymentStatusDto paymentStatusDto) {
        return modelMapper.map(paymentStatusDto, PaymentStatus.class);
    }

    /**
     * Convert List of {@link PaymentStatus} to List of {@link PaymentStatusDto}
     *
     * @param claims
     * @return
     */
    public List<PaymentStatusDto> convertToDtos(List<PaymentStatus> banks) {
        return banks.stream().map(paymentStatus -> convertToDto(paymentStatus)).collect(Collectors.toList());
    }

    /**
     * Merge {@link PaymentStatusDto} with {@link PaymentStatus}
     *
     * @param paymentStatusDto
     * @param paymentStatus
     */
    public void mergeToEntity(PaymentStatusDto paymentStatusDto, PaymentStatus paymentStatus) {
        modelMapper.map(paymentStatusDto, paymentStatus);
    }

    public PaymentStatusDto convertToPaymentStatusDto(PaymentStatus paymentStatus) {
        return modelMapper.map(paymentStatus, PaymentStatusDto.class);
    }

}
