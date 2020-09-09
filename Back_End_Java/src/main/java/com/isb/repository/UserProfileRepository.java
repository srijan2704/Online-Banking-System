package com.isb.repository;

import com.isb.entity.Customer;

public interface UserProfileRepository {
	
	public Customer userProfileRepository(long customerId);
}
