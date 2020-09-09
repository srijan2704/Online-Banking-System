package com.isb.repository;

import com.isb.entity.Customer;

public interface CustomerRepository {

	public long addCustomer(Customer customer);

	public long getCustomerId(long AccNo);

	public void getCustomer(long customerId);

	public String getCustomerByEmail(String email);

	public String getCustomerByAadharNo(String aadharNo);

	public String getCustomerByPhoneNumber(String phoneNumber);

	public String getCustomerIdByAadharNo(String aadhar);

	public Customer resetPassword(Customer customer);

	public Customer findById(long id);
	
	//dash board method
	public Customer dashBoardResetPassword(Customer customer);
}
