package com.isb.service;

import com.isb.entity.Admin;
import com.isb.entity.Customer;

public interface LoginService {
	Customer login(long customerId,String loginPassword);
	
	Admin loginAdmin(long adminId,String adminPassword);
}
