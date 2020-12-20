package com.finastra.intercashswitch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finastra.intercashswitch.dto.BankPaymentMethodDto;
import com.finastra.intercashswitch.service.BankPaymentMethodChannelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Vipin.Mangalkar
 *
 *         Bundles all CRUD APIs for Bank Payment Method Channel
 */
@Tag(name = "Bank Payment Method Channel API")
@RestController
@RequestMapping("/api/v1/bank-payment-channel")
@Validated
public class BankPaymentMethodChannelController {

	@Autowired
	private BankPaymentMethodChannelService bankPaymentMethodChannelService;

	@Operation(description = "Get Bank Payment Method Channel by channel id")
	@ApiResponse(responseCode = "200", description = "Get Bank Payment Method Channel for requested channel id", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = BankPaymentMethodDto.class)))
	@Parameters({
			@Parameter(name = "paymentMethodId", schema = @Schema(type = "Long"), in = ParameterIn.PATH, description = "Channel Id of bank payment method channel") })
	@GetMapping("/{paymentMethodId}")
	public ResponseEntity<BankPaymentMethodDto> getBankDetailsByBankId(
			@PathVariable(value = "paymentMethodId") Long paymentMethodId) {
		return new ResponseEntity<BankPaymentMethodDto>(bankPaymentMethodChannelService.getById(paymentMethodId),
				HttpStatus.OK);
	}

	@Operation(description = "Add Bank Payment Method Channel Details")
	@ApiResponse(responseCode = "201", description = "Return newly added payment method channel details", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = BankPaymentMethodDto.class)))
	@PostMapping
	public ResponseEntity<BankPaymentMethodDto> addPaymentMethodChanelDetails(
			@RequestBody @Valid BankPaymentMethodDto bankPaymentMethodDto) {
		return new ResponseEntity<BankPaymentMethodDto>(bankPaymentMethodChannelService.add(bankPaymentMethodDto),
				HttpStatus.CREATED);
	}

	@Operation(description = "Update Bank Payment Method Channel Details")
	@ApiResponse(responseCode = "200", description = "Return updated payment method channel details", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = BankPaymentMethodDto.class)))
	@PutMapping
	public ResponseEntity<BankPaymentMethodDto> updatePaymentMethodChanelDetails(
			@RequestBody @Valid BankPaymentMethodDto bankPaymentMethodDto) {
		return new ResponseEntity<BankPaymentMethodDto>(bankPaymentMethodChannelService.update(bankPaymentMethodDto),
				HttpStatus.OK);
	}

	@Operation(description = "Delete Bank Payment Method Channel Details")
	@ApiResponse(responseCode = "204", description = "Success Response", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Integer.class)))
	@Parameters({
			@Parameter(name = "paymentMethodId", schema = @Schema(type = "Long"), in = ParameterIn.PATH, description = "Payment Method Id of bank payment") })
	@DeleteMapping("/{paymentMethodId}")
	public ResponseEntity<Void> deleteBankDetails(@PathVariable(value = "paymentMethodId") Long paymentMethodId) {
		bankPaymentMethodChannelService.delete(paymentMethodId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
