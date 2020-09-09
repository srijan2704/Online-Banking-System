package com.isb.service;

import java.math.BigDecimal;
import java.util.Base64;

import javax.persistence.EntityManager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isb.entity.Account;
import com.isb.entity.Customer;
import com.isb.entity.Visitor;
import com.isb.repository.AccountRepository;
import com.isb.repository.CustomerRepository;
import com.isb.repository.VisitorRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private EntityManager em;
	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired 
	private CustomerRepository customerRepository;
	
	@Autowired
	SendEmail sendEmail; 
	
	@Autowired
	sendOtpSMS sendOtp;
	
	@Override
	@Transactional
	public String addAccountWithCustomer(long serviceRefNo) {
		
		Visitor visitor = visitorService.getVisitor(serviceRefNo);
		Customer customer = new Customer();
		Account account = new Account();
		
		BeanUtils.copyProperties(visitor, customer);
		
		String login= sendOtp.generatePass();
		String trans= sendOtp.generatePass();
		customer.setLoginPassword(Base64.getEncoder().encodeToString(login.getBytes()));			///////generate random password (8-digit)	////encode
		customer.setTransactionPassword(Base64.getEncoder().encodeToString(trans.getBytes()));		///////generate random password (8-digit) ///encode
		
		account.setAccountBalance(50000);
		account.setAccountStatus("Active");
		account.setAccountType(visitor.getAccountType());
		account.setCustomer(customer);
		
		visitorService.deleteVisitor(serviceRefNo);
		
		String email= customer.getEmail();
		if(customerRepository.getCustomerByAadharNo(customer.getAadharNo()).equals(""))
		{
			if(customerRepository.getCustomerByEmail(customer.getEmail()).equals(""))
			{
				if(customerRepository.getCustomerByPhoneNumber(customer.getPhoneNumber()).equals(""))
				{
					accountRepository.addAccount(account);
					String id= customerRepository.getCustomerIdByAadharNo(customer.getAadharNo());
					
					//String loginPass= customer.getLoginPassword();
					//String transPass= customer.getTransactionPassword();
					String info="Congratulations. You are now a part of ISB family. This is a confidential message, donot share this with anyone."
							+"Your Customer Id is "+id+", Your Login Password is "+login+", Your Transaction Password is "+trans; 
					///(mail to be generated, Congratulations, on being a part of ISB family. (body check) (detail to be sent id, pass, transpass) )
					sendEmail.Mailer(email,info);
					return "Account Created";
				}
				
				///(mail to be generated, your request for a/c creation is rejected due to phone no. provided is already linked.
				//kindly check details and register again .) 
				String info1=" your request for account creation is REJECTED due to Contact Number provided is already enrolled with us.";
				sendEmail.Mailer(email, info1);
				
				return "Account Not Created";
			}
			
			///(mail to be generated, your request for a/c creation is rejected due to email id. provided is already linked.
			//kindly check details and register again .) 
			String info2=" your request for account creation is REJECTED due to E-Mail Address provided is already enrolled with us.";
			sendEmail.Mailer(email, info2);
			
			return "Account Not Created";
			
		}
		
		///(mail to be generated, your request for a/c creation is rejected due to aadhaar no. provided is already linked.
		//kindly check details and register again .)
		String info3=" your request for account creation is REJECTED due to Aadhaar Number provided is already enrolled with us.";
		sendEmail.Mailer(email, info3);
		
		return "Account Not Created";
			
	}

	@Override
	public Account getAccount(long accNo) {
		return em.find(Account.class, accNo);
	}



	@Override
	public BigDecimal getAccountNoWithCustomerId(BigDecimal customerId) {
		return (BigDecimal)em
				.createNativeQuery("SELECT account_no FROM tb1_account WHERE customer_id=:cid")
				.setParameter("cid", customerId)
				.getSingleResult();
	}


}
