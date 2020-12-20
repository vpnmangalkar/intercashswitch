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

import com.finastra.intercashswitch.dto.BankDetailsDto;
import com.finastra.intercashswitch.service.BankDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Bundles all CRUD APIs for Bank Details
 * 
 * @author Vipin.Mangalkar
 * 
 */

@Tag(name = "Bank Details API")
@RestController
@RequestMapping("/api/v1/bank-details")
public class BankDetailsController {

	@Autowired
	private BankDetailsService bankDetailsService;

	@Operation(description = "Get Bank Details by bank id")
	@ApiResponse(responseCode = "200", description = "Get bank details for requested bank id", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = BankDetailsDto.class)))
	@Parameters({
			@Parameter(name = "bankId", schema = @Schema(type = "string"), in = ParameterIn.PATH, description = "id of bank", example = "BD-01") })
	@GetMapping("/{bankid}")
	public ResponseEntity<BankDetailsDto> getBankDetailsByBankId(@PathVariable(value = "bankid") String bankId) {
		return new ResponseEntity<BankDetailsDto>(bankDetailsService.getByBankId(bankId), HttpStatus.OK);
	}

	@Operation(description = "Add Bank Details")
	@ApiResponse(responseCode = "201", description = "Return newly added bank details", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = BankDetailsDto.class)))
	@PostMapping
	public ResponseEntity<BankDetailsDto> addBankDetails(@RequestBody @Valid BankDetailsDto bankDetailsDto) {
		return new ResponseEntity<BankDetailsDto>(bankDetailsService.add(bankDetailsDto), HttpStatus.CREATED);
	}

	@Operation(description = "Update Bank Details")
	@ApiResponse(responseCode = "200", description = "Return updated bank details", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = BankDetailsDto.class)))
	@PutMapping
	public ResponseEntity<BankDetailsDto> updateBankDetails(@RequestBody @Valid final BankDetailsDto bankDetailsDto) {
		return new ResponseEntity<BankDetailsDto>(bankDetailsService.update(bankDetailsDto), HttpStatus.OK);
	}

	@Operation(description = "Delete Bank Details")
	@ApiResponse(responseCode = "204", description = "Success Response", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)))
	@Parameters({
			@Parameter(name = "bankId", schema = @Schema(type = "string"), in = ParameterIn.PATH, description = "id of bank") })
	@DeleteMapping("/{bankid}")
	public ResponseEntity<Void> deleteBankDetails(@PathVariable(value = "bankid") String bankId) {
		bankDetailsService.delete(bankId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
