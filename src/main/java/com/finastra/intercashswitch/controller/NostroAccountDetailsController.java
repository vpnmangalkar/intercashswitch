package com.finastra.intercashswitch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finastra.intercashswitch.dto.NostroAccountDetailsDto;
import com.finastra.intercashswitch.service.NostroAccountDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Bundles all CRUD APIs for Bank Nostro Account
 * 
 * @author Vipin.Mangalkar
 * 
 */
@Tag(name = "Bank Nostro Account Details API")
@RestController
@RequestMapping("/api/v1/bank-nostro-account")
public class NostroAccountDetailsController {

	@Autowired
	private NostroAccountDetailsService nostroAccountDetailsService;

	@Operation(description = "Add Bank Nostro Account Details")
	@ApiResponse(responseCode = "201", description = "Return newly added nostro bank account details", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = NostroAccountDetailsDto.class)))
	@PostMapping
	public ResponseEntity<NostroAccountDetailsDto> addNostroAccountDetails(
			@RequestBody @Valid NostroAccountDetailsDto nostroAccountDetailsDto) {
		return new ResponseEntity<NostroAccountDetailsDto>(nostroAccountDetailsService.add(nostroAccountDetailsDto),
				HttpStatus.CREATED);
	}

	@Operation(description = "Update Bank Nostro Account Details")
	@ApiResponse(responseCode = "200", description = "Return updated bank nostro account details", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = NostroAccountDetailsDto.class)))
	@PutMapping
	public ResponseEntity<NostroAccountDetailsDto> updateNostroAccountDetails(
			@RequestBody @Valid final NostroAccountDetailsDto nostroAccountDetailsDto) {
		return new ResponseEntity<NostroAccountDetailsDto>(nostroAccountDetailsService.update(nostroAccountDetailsDto),
				HttpStatus.OK);
	}

	@Operation(description = "Delete Bank Nostro Account Details")
	@ApiResponse(responseCode = "204", description = "Success Response", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)))
	@Parameters({
			@Parameter(name = "accountId", schema = @Schema(type = "string"), in = ParameterIn.PATH, description = "account id of bank nostro account ") })
	@DeleteMapping("/{accountId}")
	public ResponseEntity<Void> deleteBankDetails(@PathVariable(value = "accountId") String accountId) {
		nostroAccountDetailsService.delete(accountId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
