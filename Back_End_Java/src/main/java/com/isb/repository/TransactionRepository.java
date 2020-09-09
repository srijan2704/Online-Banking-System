package com.isb.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.isb.dto.TransactionListDto;
import com.isb.entity.Account;
import com.isb.entity.Transaction;

public interface TransactionRepository {
	
	public void balanceUpdate(Account account);
	
	public void addTransaction(Transaction transaction);
	
	public boolean validateTransactionPassword(long customerId,String password);
	
	public BigDecimal getTransactionNo();
	
	public List<BigDecimal> getTransactionStatementBetweenDates(long accountNo, LocalDate fromDate , LocalDate toDate);
	
	public List<BigDecimal> fetchMiniStatement(long accountNo);
	
	public List<TransactionListDto> getTransactionsWithTransactionNo(List<BigDecimal> transactionNoList , long accountNo);
	
	public BigDecimal getLatestTransactionNo();
}
