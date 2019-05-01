package org.mt.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InsufficientBalanceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String status;
	private String message;


}
