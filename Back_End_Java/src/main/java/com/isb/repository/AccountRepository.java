package com.isb.repository;

import com.isb.entity.Account;

public interface AccountRepository {
	
	public long addAccount(Account account);
	
	public Account getAccount(long accNo);
}
