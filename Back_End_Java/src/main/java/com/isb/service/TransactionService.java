package com.isb.service;

import java.time.LocalDate;
import java.util.List;

import com.isb.dto.InvoiceDto;
import com.isb.dto.TransactionListDto;

public interface TransactionService {

	public InvoiceDto performTransaction(long senderAccountNo , long recieverAccountNo , double amount , String methodtype);
	
	public boolean validateTransactionPassword(long customerId,String password);
	
	public List<TransactionListDto> getTransactionStatementBetweenDates(long accountNo, LocalDate fromDate , LocalDate toDate);
	
	public List<TransactionListDto> fetchMiniStatement(long accountNo);
}
