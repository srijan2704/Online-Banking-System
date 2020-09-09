package com.isb.repository;

import java.util.Date;
import java.util.List;

import com.isb.entity.Transaction;

public interface AccountStatement {
	List<Transaction> accountStatement(long customerNo, Date from, Date to);
    long getAccountNo(long customerId);
    List<Transaction> fetchMiniStatement(long customerId);
}
