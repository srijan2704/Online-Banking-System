package com.isb.service;

import java.math.BigDecimal;

import com.isb.entity.Account;

public interface AccountService {

	public String addAccountWithCustomer(long serviceRefNo);
	
	public Account getAccount(long accNo);
	
	public BigDecimal getAccountNoWithCustomerId(BigDecimal customerId);
}
