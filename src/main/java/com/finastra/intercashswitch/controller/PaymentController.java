package com.finastra.intercashswitch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finastra.intercashswitch.dto.PaymentInitiationDto;
import com.finastra.intercashswitch.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Bundles all Payment Related APIs
 * 
 * @author Vipin.Mangalkar
 * 
 */
@Tag(name = "Payment Details API")
@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@Operation(description = "Payment Initiation")
	@ApiResponse(responseCode = "201", description = "Return payment reference id of the transaction", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = PaymentInitiationDto.class)))
	@PostMapping
	public ResponseEntity<String> initiatePayment(@RequestBody @Valid PaymentInitiationDto paymentInitiationDto) {
		return new ResponseEntity<String>(paymentService.initiatePayment(paymentInitiationDto), HttpStatus.CREATED);
	}

}
