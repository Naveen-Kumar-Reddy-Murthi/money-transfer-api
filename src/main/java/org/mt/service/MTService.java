package org.mt.service;

import org.mt.model.Status;
import org.mt.model.Transaction;

public interface MTService {
	
	Status debit(Transaction txn ) throws Exception;
	
	Status credit(Transaction txn ) throws Exception;

}
