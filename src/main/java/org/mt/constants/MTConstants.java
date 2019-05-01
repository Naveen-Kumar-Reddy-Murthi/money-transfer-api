package org.mt.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum MTConstants {
	
	NEW("NEW"),
    INSUFFICIENT_FUNDS("Insufficient Funds"),
    COMPLETED("Completed"),
    FAILED("Failed"),
    DEBIT("D"),
    CREDIT("C"),
	INVALID_REQUEST("Invalid Request Type"),
	VALIDATION_ERROR("Validation Error"),
	INVALID_ACC_NO("Invalid Debit Account Number"),
	INVALID_TXN_TYPE("Invalid Transaction Type"),
	INVALID_TXN_AMT("Invalid Transaction Amount"),
	Y("Y"),
	TXN_SUCCESS("Transaction Successful"),
	ONE("1"),
	ZERO("0"),
	OK("200");
	
	protected  @Getter @Setter String value;


}
