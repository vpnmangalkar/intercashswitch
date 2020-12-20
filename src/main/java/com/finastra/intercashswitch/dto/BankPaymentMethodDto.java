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
@Schema(description = "Bank Payment Method  - Information about the Payment Method  e.g. Payment initiation through API/XML/SFTP/MQ and Same methods for Liquidation")
public class BankPaymentMethodDto {

	@JsonIgnore
	@Schema(description = "Payment Method Id of the Bank Payment Method Channel")
	private Long paymentMethodId;

	@Schema(description = "Bank id of the Bank")
	@NotBlank(message = "Bank id required")
	private String bankId;

	@Schema(description = "Payment Mode id of the Bank (PAY_INIT/LIQUIDATE)")
	@NotBlank(message = "Payment mode required")
	private String paymentMode;

	@Schema(description = "Channel Type for the payment or liquidation (XML/MQ/HTHFILE/API) ")
	@NotBlank(message = "Channel type required")
	private String channelType;

	@Schema(description = "API URL for payment channel (payment or liquidation)")
	private String apiUrl;
	
	@Schema(description = "API User Id for payment channel (payment or liquidation)")
	private String apiUserId;
	
	@Schema(description = "API User Id for payment channel (payment or liquidation)")
	private String apiPassword;
	
	@Schema(description = "FTP Type F or S (F-[FTP], S-[SFTP]")
	private String ftpType;
	
	@Schema(description = "FTP Server Name")
	private String ftpServer;
	
	@Schema(description = "FTP Server User Id")
	private String ftpUser;
	
	@Schema(description = "FTP Server Password")
	private String ftpPwd;
	
	@Schema(description = "FTP Server Port")
	private String ftpPort;
	
	@Schema(description = "FTP Server Path")
	private String ftpPath;
	
	@Schema(description = "FTP Server File Temp Directory")
	private String fileTempDir;

	@Schema(description = "MQ ID for payment channel (payment or liquidation)")
	private String mqId;
	
	@Schema(description = "MQ Session Name")
	private String mqSessionName;

	@Schema(description = "MQ Request Queue Name")
	private String mqReqQName;
	
	@Schema(description = "MQ Response Queue Name")
	private String mqResQName;
	
	@Schema(description = "MQ Connectione Name")
	private String mqConnectionName;
	
	@Schema(description = "MQ User Name")
	private String mqUser;
	
	@Schema(description = "MQ Password")
	private String mqPassword;
	
	@Schema(description = "Message Corelation Flag")
	private String msgCorrelatedFlag;
	
	@Schema(description = "Seller Code for (payment or liquidation)")
	@NotBlank(message = "Seller code required")
	private String sellerCode;

	@Schema(description = "Default Package Code for (payment or liquidation)")
	@NotBlank(message = "Default package code required")
	private String defaultPackageCode;
}
