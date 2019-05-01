package org.mt.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Transaction {
	
	private long id;
	private Date txnDate;
	private String debitAccNo;
	private String creditAccNo;
	private String type;
	private BigDecimal txnAmount;
	private String status;

}
