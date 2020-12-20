package com.finastra.intercashswitch.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Schema(description = "Bank Details - Information about the bank.")
public class PaymentStatusDto {

	@JsonIgnore
	private Long statusId;

	@NotBlank(message = "Payment Id required")
	@Schema(description = "Payment Id of Transaction ")
	private String payId;

	@JsonIgnore
	private Integer serialId = 1;

	@NotBlank(message = "Payment status required")
	@Schema(description = "Payment Status of Transaction ")
	private String status;

	@Schema(description = "Payment Error Code ")
	private String errorCode;

	@Schema(description = "Payment Error Reason ")
	private String errorReason;

	@JsonIgnore
	private String reqResId;
}
