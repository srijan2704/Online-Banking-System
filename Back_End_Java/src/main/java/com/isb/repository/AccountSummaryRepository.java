package com.isb.repository;

import com.isb.entity.Account;

public interface AccountSummaryRepository {
	public Account accountSummary(long customerId);
}
