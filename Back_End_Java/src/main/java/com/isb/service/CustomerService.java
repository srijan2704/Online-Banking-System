package com.isb.service;

import com.isb.entity.Customer;

public interface CustomerService {

	public String addCustomer(Customer customer);
	
	public long getCustomerId(long AccNo);
	
	public void getCustomer(long customerId);
	
	public boolean preResetCheck(long customerId);
	
	public boolean resetPassword(long customerId, String password);
	
	public boolean validateOtp(String otp);
	
	public boolean dashBoardresetPassword(long customerId, String loginPassword, String transPassword);
}
