package org.mt.dao;

import org.mt.model.Account;
import org.mt.model.Transaction;

public interface MTDao {
	
	String GET_ACCT_QUERY     = "select * from Account where accountNumber = ? ";
	String UPDATE_ACCT_QUERY  = "update Account set currentbalance = ?  where accountNumber = ? ";
	String TXN_INSERT_QUERY   = "insert into transaction(type, debitAccNo, creditAccNo, txnAmount, status) values(?, ?, ?, ?, ?)";
	
	int updateAccounts(Transaction txn, Account account) throws Exception;
	
	Account getAccount(String accountNumber) throws Exception;
	
}
