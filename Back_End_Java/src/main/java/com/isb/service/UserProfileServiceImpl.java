package com.isb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isb.entity.Customer;
import com.isb.repository.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public Customer UserProfileService(long customerId) {
		 Customer userProfile = userProfileRepository.userProfileRepository(customerId);

         return userProfile;
	}
	
	

}
