package org.mt.servie.impl;

import java.math.BigDecimal;

import org.mt.constants.MTConstants;
import org.mt.dao.MTDao;
import org.mt.dao.impl.MTDaoImpl;
import org.mt.exceptions.MTValidationException;
import org.mt.model.Account;
import org.mt.model.Status;
import org.mt.model.Transaction;
import org.mt.service.MTService;

public class MTServiceImpl implements MTService {
	
	private MTDao  dao = new MTDaoImpl();
	private Status status = null;

	public Status debit(Transaction txn) throws Exception {

		Account account = dao.getAccount(txn.getDebitAccNo());
		int count = 0;

		if (null == account) {
			throw new MTValidationException(MTConstants.FAILED.getValue(), MTConstants.INVALID_ACC_NO.getValue());
		} else if (account.getCurrentBalance().compareTo(txn.getTxnAmount()) < 0) {
			throw new MTValidationException(MTConstants.FAILED.getValue(), MTConstants.INSUFFICIENT_FUNDS.getValue());
		} else {
			BigDecimal newBalance = account.getCurrentBalance().subtract(txn.getTxnAmount());
			System.out.println("new balance after soft debit "+ newBalance.toString());
			account.setCurrentBalance(newBalance);
			System.out.println("new balance after hard debit "+ account.getCurrentBalance().toString());
			  count = dao.updateAccounts(txn, account);
		}
		
		if(count == 1) {
			status = new Status(MTConstants.ONE.getValue(), MTConstants.TXN_SUCCESS.getValue());
		}
		

		return status;
	}

	public Status credit(Transaction txn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
