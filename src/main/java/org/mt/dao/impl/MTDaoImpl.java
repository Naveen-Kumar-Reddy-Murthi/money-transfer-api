package org.mt.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.mt.constants.MTConstants;
import org.mt.dao.MTDao;
import org.mt.model.Account;
import org.mt.model.Transaction;
import org.mt.util.DBUtils;

public class MTDaoImpl implements MTDao {
	
	QueryRunner runner =  null;

	public int updateAccounts(Transaction txn, Account account) throws Exception {
		runner = new QueryRunner();
		int updateCount = runner.update(DBUtils.getConnection(), MTDao.UPDATE_ACCT_QUERY, account.getCurrentBalance(),
				account.getAccountNumber());
		int insertCount = runner.update(DBUtils.getConnection(), MTDao.TXN_INSERT_QUERY, txn.getType(),
				txn.getDebitAccNo(), txn.getCreditAccNo(), txn.getTxnAmount(), MTConstants.Y.getValue());
		runner = null;
		if (updateCount == 1 || insertCount ==1) {
			return 1;
		} else {
			return 0;
		}
	}

	public Account getAccount(String accountNumber) throws Exception {
		runner = new QueryRunner();
		Account account = runner.query(DBUtils.getConnection(), MTDao.GET_ACCT_QUERY,
				new BeanHandler<Account>(Account.class), accountNumber);
		runner = null;
		return account;
	}

}
