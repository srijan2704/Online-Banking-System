package com.isb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isb.entity.Admin;
import com.isb.entity.Customer;
import com.isb.exception.LoginServiceException;
import com.isb.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepository loginRepository;
	
	private static int counter = 3;
	
	@Override
	public Customer login(long customerId, String loginPassword) {
		try {
			long id = loginRepository.findCustomerByIdPassword(customerId, loginPassword);
			Customer customer = loginRepository.findCustomerById(id);
			return customer;
			
		}
		catch(LoginServiceException e)
		{
			counter--;
			throw new LoginServiceException("Invalid UserId/Password");
		}
	}

	@Override
	public Admin loginAdmin(long adminId, String adminPassword) {
		try
		{
			long adminId1 = loginRepository.findAdminByIdPassword(adminId, adminPassword);
			Admin admin = loginRepository.findAdminById(adminId1);
			return admin;
		}
		catch(LoginServiceException e)
		{
			throw new LoginServiceException("Invalid Admin Id/Password");
		}
	}
	

}
