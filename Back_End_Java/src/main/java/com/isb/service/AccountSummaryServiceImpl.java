package com.isb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isb.entity.Account;
import com.isb.repository.AccountSummaryRepository;
@Service
public class AccountSummaryServiceImpl implements AccountSummaryService{

	@Autowired
	private AccountSummaryRepository accountSummaryRepository;
	@Override
	public Account accountSummary(long customerId) {
		Account accountSummary = accountSummaryRepository.accountSummary(customerId);

        return accountSummary;
	}

}
