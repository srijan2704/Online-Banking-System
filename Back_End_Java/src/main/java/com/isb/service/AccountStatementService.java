package com.isb.service;

import java.util.Date;
import java.util.List;

import com.isb.entity.Transaction;

public interface AccountStatementService {
	
	List<Transaction> accountStatement(long customerId,Date from,Date to);
	List<Transaction> miniStatementList(long customerId);
}
