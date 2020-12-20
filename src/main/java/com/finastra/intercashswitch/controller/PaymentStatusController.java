package com.finastra.intercashswitch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finastra.intercashswitch.dto.PaymentStatusDto;
import com.finastra.intercashswitch.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Bundles all Payment Status APIs
 * 
 * @author Vipin.Mangalkar
 * 
 */
@Tag(name = "Payment Status Details API")
@RestController
@RequestMapping("/api/v1/payment-status")
public class PaymentStatusController {

	@Autowired
	private PaymentService paymentService;

	@Operation(description = "Payment Status")
	@ApiResponse(responseCode = "201", description = "Return payment reference id of the transaction", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = PaymentStatusDto.class)))
	@PostMapping
	public ResponseEntity<PaymentStatusDto> updatePaymentStatus(@RequestBody @Valid PaymentStatusDto paymentStatusDto) {
		return new ResponseEntity<PaymentStatusDto>(paymentService.update(paymentStatusDto), HttpStatus.CREATED);
	}

	@Operation(description = "Get Payment Status")
	@ApiResponse(responseCode = "200", description = "Get payment status for requested payment reference id", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = PaymentStatusDto.class)))
	@Parameters({ @Parameter(name = "payId", schema = @Schema(type = "string"), in = ParameterIn.PATH, description = "id of payment/transaction") })
	@GetMapping("/{payId}")
	public ResponseEntity<PaymentStatusDto> getPaymentStatus(@PathVariable(value = "payId") String payId) {
		return new ResponseEntity<PaymentStatusDto>(paymentService.getPaymentStatus(payId), HttpStatus.OK);
	}

}
