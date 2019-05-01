package org.mt.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Account {
	
	private long id;
	private String accountNumber;
	private String active;
	private Date openDate;
	private BigDecimal currentBalance;
	

}
