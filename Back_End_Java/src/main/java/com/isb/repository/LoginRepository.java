package com.isb.repository;

import com.isb.entity.Admin;
import com.isb.entity.Customer;

public interface LoginRepository {
	
	public Customer findCustomerById(long customer_id);
	
	public long findCustomerByIdPassword(long customerId,String password);
	
	public Admin findAdminById(long adminId);
	
	public long findAdminByIdPassword(long adminId,String adminPassword);
}
