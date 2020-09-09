package com.isb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.isb.controller.VisitorController;
import com.isb.dto.VisitorRegisterDto;
import com.isb.entity.Account;
import com.isb.entity.Customer;
import com.isb.entity.Region;
import com.isb.entity.Visitor;
import com.isb.repository.AccountRepository;
import com.isb.repository.AccountStatement;
import com.isb.repository.CustomerRepository;
import com.isb.repository.VisitorRepository;
import com.isb.service.VisitorService;

@SpringBootTest
class IsbBankSpringApplicationTests {

	@Autowired
	private VisitorController controller;
	
	@Autowired
	AccountStatement accountStatement;
	
	@Autowired
	private VisitorService service;
	
	@Autowired
	private CustomerRepository repoCustomer;
	
	@Autowired
	private AccountRepository repoAccount;
	
	@Test
	void getCustomerById()
	{
		System.out.println(accountStatement.getAccountNo(102));
	}
	
//	@Test
//	void getRegionId()
//	{
//		String city = "Chandigarh";
//		String pincode = "160011";
//		String state = "Haryana";
//		
//		System.out.println(repo.getRegionId(city, pincode, state));
//	}
	
	
	 @Test 
	 void addVisitor() { 
	  VisitorRegisterDto visitor = new
	  VisitorRegisterDto();
	  
	  visitor.setAccountType("Salaried"); visitor.setFirstName("Ayush");
	  visitor.setLastName("Singh"); visitor.setAge(22);
	  visitor.setAadharNo("683761168716"); visitor.setDebitCardStatus("Required");
	  visitor.setEmail("shivamayush54@gmail.com"); visitor.setGender("Male");
	  visitor.setGrossAnnualIncome(500000);
	  visitor.setLocalAddress("Hno 118B Malik colony");
	  visitor.setNetBankingStatus("NotRequired");
	  visitor.setOccupationType("service");
	  visitor.setPermanentAddress("Hno 118B Malik colony");
	  visitor.setPermanentAddress("Hno 118B Malik colony");
	  visitor.setPhoneNumber("9045751789"); visitor.setSourceOfIncome("LTI");
	  visitor.setLocalCity("Chandigarh"); visitor.setLocalPincode("160011");
	  visitor.setLocalState("Haryana"); visitor.setPermanentCity("Chandigarh");
	  visitor.setPermanentPincode("160011"); visitor.setPermanentState("Haryana");
	  
	  System.out.println(controller.registerVisitor(visitor)); }
	 
	
//	@Test
//	void checkVisitorStatus()
//	{
//		System.out.println(service.checkVisitorStatus(1003));
//	}
//	
//	@Test 
//	void setVisitorStatus()
//	{
//		service.setVisitorStatus(1003, "accepted");
//	}
//	
	/*
	 * @Test void deleteVisitor() { service.deleteVisitor(1003); }
	 */
//
//	@Test
//	void getVisitor()
//	{
//		System.out.println(service.getVisitor(1003));
//	}
	
//	@Test
//	void addCustomer()
//	{
//		Visitor visitor = service.getVisitor(1001);
//		Customer customer = new Customer();
//		Account account = new Account();
//		
//		BeanUtils.copyProperties(visitor, customer);
//		
//		customer.setLoginPassword("123456");
//		customer.setTransactionPassword("123456");
//		
//		account.setAccountBalance(50000);
//		account.setAccountStatus("Active");
//		account.setAccountType(visitor.getAccountType());
//		account.setCustomer(customer);
//		
//		repoAccount.addAccount(account);
//	}
}
