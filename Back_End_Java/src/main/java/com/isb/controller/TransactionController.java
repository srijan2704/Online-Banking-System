package com.isb.controller;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.isb.dto.AccountStatementDto;
import com.isb.dto.CustomerIdBDto;
import com.isb.dto.CustomerIdDto;
import com.isb.dto.InvoiceDto;
import com.isb.dto.TransactionAccountsAndPasswordDto;
import com.isb.dto.TransactionListDto;
import com.isb.service.AccountService;
import com.isb.service.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private AccountService accountService;

	@PutMapping("/makeTransaction")
	public InvoiceDto makeTransaction(@RequestBody TransactionAccountsAndPasswordDto accountsAndPasswordDto)
	{
		String password = Base64.getEncoder().encodeToString(accountsAndPasswordDto.getPassword().getBytes());
		if(accountsAndPasswordDto.getAmount() > 0 && transactionService.validateTransactionPassword(accountsAndPasswordDto.getCustomerId().longValue(),password))
		{
			return transactionService.performTransaction(accountsAndPasswordDto.getFromAccount().longValue(), 
					accountsAndPasswordDto.getToAccount().longValue(), accountsAndPasswordDto.getAmount(), 
					accountsAndPasswordDto.getMethodtype());
		}
		InvoiceDto invoiceDto = new InvoiceDto();
		invoiceDto.setStatus("Transaction Unsuccessful...Invalid Transaction Password");
		return invoiceDto;
	}
	
	@PostMapping("/miniStatement")
	public List<TransactionListDto> fetchMiniStatement(@RequestBody CustomerIdBDto customerIdDto)
	{
		long accountNo = accountService.getAccountNoWithCustomerId(customerIdDto.getCustomerId()).longValue();
		return transactionService.fetchMiniStatement(accountNo);
	}
	
	@PostMapping("/accountStatement")
	public List<TransactionListDto> getTransactionStatementBetweenDates(@RequestBody AccountStatementDto accountStatementDto) 
	{
		return transactionService.getTransactionStatementBetweenDates(accountStatementDto.getAccountNo(), accountStatementDto.getFromDate(), accountStatementDto.getToDate());
	}
}
