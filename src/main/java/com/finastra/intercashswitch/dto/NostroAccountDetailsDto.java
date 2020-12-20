package com.finastra.intercashswitch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Vipin.Mangalkar
 *
 */

@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Settlement Bank Account Details - Information about the banks and partner bank settlement account details.")
public class NostroAccountDetailsDto {

	@Schema(description = "Uniue Account Id for the Settlement Account")
	private String accountId;

	/*
	 * @Schema(description = "Owner Banks Bank Id") private Long ownerBankId;
	 * 
	 * @Schema(description = "Partner Banks Bank Id") private Long partnerBankId;
	 */
	@Schema(description = "Owner Banks Swift Code")
	private String ownerSwiftCode;

	@Schema(description = "Owner Banks BIC Code")
	private String ownerBicCode;

	@Schema(description = "Partner Banks Swift Code")
	private String partnerSwiftCode;

	@Schema(description = "Partner Banks BIC Code")
	private String partnerBicCode;

	@Schema(description = "GL Id for the Settlement Account")
	private String glId;

	@Schema(description = "Currency Code")
	private String ccyCode;

	@Schema(description = "Branch Id of the Owner Bank")
	private String branchId;

	@Schema(description = "Branch Name of the Owner Bank")
	private String branchName;

}
