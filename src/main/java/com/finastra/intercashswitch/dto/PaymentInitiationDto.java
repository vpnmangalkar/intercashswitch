package com.finastra.intercashswitch.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

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
@Schema(description = "Payment Initiation - Information about the Payment.")
public class PaymentInitiationDto {

	@Schema(description = "PayId - Payment Reference Identifire of Transaction")
	private String payId;

	// @JsonIgnore
	private String fromBankId;

	private LocalDateTime makerTime;

	@NotBlank(message = "Transaction Refrence Number required")
	private String originatingTxnNmbr;

	@NotBlank(message = "Transaction Refrence required")
	private String interSellerTxnRefNmbr;

	private String appcode;

	@NotBlank(message = "Client Codee required")
	private String clientCode;

	@NotBlank(message = "Beneficiary required")
	private String beneCode;

	@NotBlank(message = "Beneficiary description required")
	private String beneDescription;

	@NotBlank(message = "Beneficiary Bank Account Number required")
	private String beneAccountNmbr;

	@NotBlank(message = "Beneficiary Bank IBAN required")
	private String beneAccountIban;
	
	@NotBlank(message = "Bank Swift Code required")
	private String beneBankSwift;

	@NotBlank(message = "Bank BIC Code required")
	private String beneBankBic;

	@NotBlank(message = "Beneficiary Bank Code required")
	private String beneBankCode;

	@NotBlank(message = "Beneficiary Bank Branch Code required")
	private String beneBranchCode;

	@NotBlank(message = "Beneficiary Address required")
	private String beneAddr;

	@NotBlank(message = "Beneficiary Bank Address required")
	private String beneBankAddr;

	@NotBlank(message = "Beneficiary Mobile required")
	private String beneMobile;

	@NotBlank(message = "Beneficiary Phone required")
	private String benePhoneNmbr;

	@NotBlank(message = "Beneficiary Pin code required")
	private String benePinCode;

	@NotBlank(message = "Beneficiary Business Regs required")
	private String beneBusinessRegs;

	@NotBlank(message = "Beneficiary Currency required")
	private String beneCcy;

	@NotBlank(message = "Beneficiary Email required")
	private String beneEmail;

	private String beneFax;

	@NotBlank(message = "Beneficiary Id required")
	private String beneId;

	@NotBlank(message = "Beneficiary IVR Code required")
	private String beneIvrCode;

	@NotBlank(message = "Beneficiary Non Residen Indicator required")
	private String beneNonResiIndicator;

	
	@NotBlank(message = "Beneficiary Passport required")
	private String benePassportNo;

	@NotBlank(message = "Beneficiary Payment Details required")
	private String benePaymentDetails;

	@NotBlank(message = "By Order Of required")
	private String byOrderOf;

	@NotBlank(message = "CO Advice Layout required")
	private String coAdviceLayout;

	@NotBlank(message = "CO Auth Person IC required")
	private String coAuthPersonIc;

	@NotBlank(message = "CO Auth Person name required")
	private String coAuthPersonName;

	@NotBlank(message = "CO Auth CollBr required")
	private String coCollBr;

	@NotBlank(message = "CO Drawee required")
	private String coDraweeBranch;

	@NotBlank(message = "CO Mailing City required")
	private String co_mailing_city;

	@NotBlank(message = "CO Mailing Country required")
	private String coMailingCountry;

	private Integer coMailingPostcode;

	private String coMailingState;

	@NotBlank
	private String originatingEntityType;

	@NotBlank
	private String originatingEntityCode;

	@NotBlank
	private String originatingEntityAcctNmbr;

	@NotBlank
	private String originatingEntityCcy;

	private String originatingEntityBankId;

	@NotBlank
	private String originatingEntityBankName;

	@NotBlank
	private String originatingEntityBranchId;

	@NotBlank
	private String originatingEntityBranchName;

	@NotBlank
	private String originatingEntityBic;

	@NotBlank
	private String originatingEntitySwift;

	@NotBlank
	private String originatingEntityDrAmnt;

	@NotBlank
	private String originatingTxnPayCcy;

	@NotBlank
	private String originatingTxnPayCountry;

	@NotBlank
	private String originatingTxnPaySeller;

	@NotBlank
	private String recipientEntityType;

	@NotBlank
	private String recipientEntityCode;

	@NotBlank
	private String recipientEntityAcctNmbr;

	@NotBlank
	private String recipientEntityCcy;

	private String recipientEntityBankId;

	@NotBlank
	private String recipientEntityBankName;

	@NotBlank
	private String recipientEntityBranchId;

	@NotBlank
	private String recipientEntityBranchName;

	@NotBlank
	private String recipientEntityDrAmnt;

	@NotBlank
	private String recipientTxnPayCcy;

	@NotBlank
	private String recipientEntityBic;

	@NotBlank
	private String recipientEntitySwift;

	private Double nostrDrAmount;

	private Double beneCrAmount;

	private String status;
}
