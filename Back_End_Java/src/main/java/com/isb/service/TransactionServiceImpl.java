package com.isb.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isb.dto.InvoiceDto;
import com.isb.dto.TransactionListDto;
import com.isb.entity.Account;
import com.isb.entity.Transaction;
import com.isb.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountService accountService;

	@Override
	@Transactional
	public InvoiceDto performTransaction(long senderAccountNo, long recieverAccountNo, double amount,
			String methodType) {

		InvoiceDto invoiceDto = new InvoiceDto();

		BigDecimal transactionNo = transactionRepository.getTransactionNo();

		Account senderAccount = accountService.getAccount(senderAccountNo);

		Transaction senderTransaction = new Transaction();
		senderTransaction.setAccount(senderAccount);
		senderTransaction.setOpeningBalance(senderAccount.getAccountBalance());
		senderTransaction.setTransactionAmount(amount);
		senderTransaction.setTransactionDate(Date.valueOf(LocalDate.now(Clock.systemUTC())));
		senderTransaction.setTransactionDateAndTime(LocalDateTime.now(Clock.systemUTC()));
		senderTransaction.setTransactionMethod(methodType);
		senderTransaction.setTransactionType("Debit");

		BeanUtils.copyProperties(senderTransaction, invoiceDto);
		invoiceDto.setFromAccount(senderAccountNo);
		invoiceDto.setToAccount(recieverAccountNo);
		if (methodType.equals("IMPS") && amount > 200000) {
			invoiceDto.setStatus("Transaction failed... IMPS transactions should have amount less than 200000");
			return invoiceDto;
		}
		if (methodType.equals("RTGS") && amount < 200000) {
			invoiceDto.setStatus("Transaction failed... RTGS transactions should have amount more than 200000");
			return invoiceDto;
		}
		if (amount > senderAccount.getAccountBalance()) {
//			senderTransaction.setClosingBalance(senderAccount.getAccountBalance());
//			senderTransaction.setTransactionStatus("Failed");
//			transactionRepository.addTransaction(senderTransaction);
			invoiceDto.setCurrentBalance(senderAccount.getAccountBalance());
			invoiceDto.setStatus("Transaction Failed, Insufficient Balance");
			return invoiceDto;
		}

		Account recieverAccount = accountService.getAccount(recieverAccountNo);

		Transaction recieverTransaction = new Transaction();
		recieverTransaction.setAccount(recieverAccount);
		recieverTransaction.setOpeningBalance(recieverAccount.getAccountBalance());
		recieverTransaction.setTransactionAmount(amount);
		recieverTransaction.setTransactionDate(Date.valueOf(LocalDate.now()));
		recieverTransaction.setTransactionDateAndTime(LocalDateTime.now());
		recieverTransaction.setTransactionMethod(methodType);
		recieverTransaction.setTransactionType("Credit");

		if (senderAccount.getAccountStatus().equals("Active") && recieverAccount.getAccountStatus().equals("Active")) {
			senderAccount.setAccountBalance(senderAccount.getAccountBalance() - amount);
			transactionRepository.balanceUpdate(senderAccount);
			senderTransaction.setClosingBalance(senderAccount.getAccountBalance());
			senderTransaction.setTransactionStatus("Success");
			senderTransaction.setTransactionNo(transactionNo.longValue());
			transactionRepository.addTransaction(senderTransaction);
			invoiceDto.setTransactionId(transactionRepository.getLatestTransactionNo().longValue());

			recieverAccount.setAccountBalance(recieverAccount.getAccountBalance() + amount);
			transactionRepository.balanceUpdate(recieverAccount);
			recieverTransaction.setClosingBalance(recieverAccount.getAccountBalance());
			recieverTransaction.setTransactionStatus("Success");
			recieverTransaction.setTransactionNo(transactionNo.longValue());
			transactionRepository.addTransaction(recieverTransaction);

			invoiceDto.setCurrentBalance(senderAccount.getAccountBalance());
			invoiceDto.setStatus("Transaction Successful");
			return invoiceDto;
		}
		invoiceDto.setCurrentBalance(senderAccount.getAccountBalance());
		invoiceDto.setStatus("Transaction Failed.. Account not active");
		return invoiceDto;
	}

	@Override
	public boolean validateTransactionPassword(long customerId, String password) {
		return transactionRepository.validateTransactionPassword(customerId, password);
	}

	@Override
	public List<TransactionListDto> getTransactionStatementBetweenDates(long accountNo, LocalDate fromDate,
			LocalDate toDate) {

		return transactionRepository.getTransactionsWithTransactionNo(
				transactionRepository.getTransactionStatementBetweenDates(accountNo, fromDate, toDate), accountNo);
	}

	@Override
	public List<TransactionListDto> fetchMiniStatement(long accountNo) {

		return transactionRepository
				.getTransactionsWithTransactionNo(transactionRepository.fetchMiniStatement(accountNo), accountNo);
	}

}
