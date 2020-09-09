package com.isb.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isb.entity.Customer;
import com.isb.exception.CustomerServiceExceptions;
import com.isb.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	SendEmail sendEmail; 

	private static String otpStr;
	
	@Override
	public void getCustomer(long customerId) {
		customerRepository.getCustomer(customerId);
	}
	
	@Override
	@Transactional
	public String addCustomer(Customer customer) {
		String email= customer.getEmail();
		if(customerRepository.getCustomerByAadharNo(customer.getAadharNo()).equals(""))
		{
			if(customerRepository.getCustomerByEmail(customer.getEmail()).equals(""))
			{
				if(customerRepository.getCustomerByPhoneNumber(customer.getPhoneNumber()).equals(""))
				{
					
					long id=customerRepository.addCustomer(customer);
					
					String loginPass= customer.getLoginPassword();
					String transPass= customer.getTransactionPassword();
					String info="Congratulations. You are now a part of ISB family. This is a confidential message, donot share this with anyone."
							+"Your Customer Id is "+id+", Your Login Password is "+loginPass+", Your Transaction Password is "+transPass; 
					///(mail to be generated, Congratulations, on being a part of ISB family. (body check) (detail to be sent id, pass, transpass) )
					sendEmail.Mailer(email, info);
					return "Account Created";
				}
				
				///(mail to be generated, your request for a/c creation is rejected due to phone no. provided is already linked.
				//kindly check details and register again .) 
				String info1="Greetings, your request for account creation is REJECTED due to Contact Number provided is already enrolled with us.";
				sendEmail.Mailer(email, info1);
				return "Account Not Created";
			}
			
			///(mail to be generated, your request for a/c creation is rejected due to email id. provided is already linked.
			//kindly check details and register again .) 
			String info1="Greetings, your request for account creation is REJECTED due to E-Mail Address provided is already enrolled with us.";
			sendEmail.Mailer(email, info1);
			
			return "Account Not Created";
			
		}
		
		///(mail to be generated, your request for a/c creation is rejected due to aadhaar no. provided is already linked.
		//kindly check details and register again .)
		String info1="Greetings, your request for account creation is REJECTED due to Aadhaar Number provided is already enrolled with us.";
		sendEmail.Mailer(email, info1);
		
		return "Account Not Created";
	}

	@Override
	public long getCustomerId(long accNo) {
		return customerRepository.getCustomerId(accNo);
	}

	@Override
	public boolean preResetCheck(long customerId) {
		Customer c= customerRepository.findById(customerId);
		if(c !=null) 
		{
			otpStr = sendOtpSMS.generateOtp();
			System.out.println("Generated OTP= " + otpStr);
			sendOtpSMS.sendSMS(otpStr,c.getPhoneNumber());
			return true;
		}
		
		throw new CustomerServiceExceptions("Enter Valid User ID");
		
	}

	@Override
	@Transactional
	public boolean resetPassword(long customerId, String password) {
		Customer c=customerRepository.findById(customerId);
		if(c != null) {
		String encoded=Base64.getEncoder().encodeToString(password.getBytes());
		c.setLoginPassword(encoded);
		Customer c1=customerRepository.resetPassword(c);
		System.out.println(c1);
		return true;
		}
		// won't fail as the check has been done previously in pre-reset check
		throw new CustomerServiceExceptions("user not found");
	}
	
	@Override
	public boolean validateOtp(String otp) {
		if(otp.equals(otpStr)) {
			return true;
		}
		return false;
	}
	
	@Override
	@Transactional
	public boolean dashBoardresetPassword(long customerId, String loginPassword, String transPassword) {
		Customer c=customerRepository.findById(customerId);
		if(c != null) {
		String encodedLogin=Base64.getEncoder().encodeToString(loginPassword.getBytes());
		String encodedTrans=Base64.getEncoder().encodeToString(transPassword.getBytes());
		c.setLoginPassword(encodedLogin);
		c.setTransactionPassword(encodedTrans);
		Customer c1=customerRepository.resetPassword(c);
		System.out.println(c1);
		return true;
		}
		// won't fail as the check has been done previously in pre-reset check
		throw new CustomerServiceExceptions("user not found");
	}

}
