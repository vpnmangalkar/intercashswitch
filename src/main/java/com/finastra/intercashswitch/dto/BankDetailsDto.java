package com.finastra.intercashswitch.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Bank Details - Information about the bank.")
public class BankDetailsDto {

	@Schema(description = "Bank id of the Bank")
	private String bankId;

	@NotBlank(message = "Bank name required")
	@Schema(description = "Name of the Bank")
	private String bankName;

	@NotBlank(message = "Bank branch required")
	@Schema(description = "System Controlling Branch of the Bank")
	private String sysControllingBranch;

	@NotBlank(message = "Swift Code required")
	@Schema(description = "Swift Code of the Bank")
	private String swiftCode;

	@NotBlank(message = "BIC Code required")
	@Schema(description = "BIC Code of the Bank")
	private String bicCode;

	@NotBlank(message = "MICR Code required")
	@Schema(description = "MICR Code of the Bank")
	private String micrCode;

	@NotBlank(message = "Country Code required")
	@Schema(description = "Country Code of the Bank")
	private String countryCode;

	@NotBlank(message = "Address 1 required")
	@Schema(description = "Address 1 of the Bank")
	private String address1;

	@Schema(description = "Address 2 of the Bank")
	private String address2;

	@Schema(description = "Address 3 of the Bank")
	private String address3;

	@Schema(description = "Address 4 of the Bank")
	private String address4;

	@Schema(description = "Address 5 of the Bank")
	private String address5;

	@Schema(description = "Dummy Client Code of the Bank")
	private String dummyClientCode;

	@Schema(description = "Dummy Package Code of the Bank")
	private String dummyPackageCode;
	
	@JsonIgnore
	@Schema(description = "Active Status")
	private String isActive = "Y";
}
