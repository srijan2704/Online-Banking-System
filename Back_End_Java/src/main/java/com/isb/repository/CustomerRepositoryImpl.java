package com.isb.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.isb.entity.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public long addCustomer(Customer customer) {
		em.merge(customer);
		return customer.getCustomerId();
	}

	@Override
	public long getCustomerId(long AccNo) {
		return em
				.createNativeQuery("SELECT customer_id FROM tb1_Customer WHERE account_no=:ac")
				.setParameter("ac", AccNo)
				.getFirstResult();
				
	}

	@Override
	public void getCustomer(long customerId) {
		em.find(Customer.class,customerId);
	}
	
	@Override
	public String getCustomerByEmail(String email) {
		try{
			String email_res =	em
							.createNativeQuery("SELECT email FROM tb1_Customer WHERE email=:em")
							.setParameter("em", email)
							.getSingleResult().toString();
			return email_res; 
		}catch (NoResultException e) {
			return "";
		}
	}

	@Override
	public String getCustomerByAadharNo(String aadharNo) {
		try{
			String aadhar_res =	em
							.createNativeQuery("SELECT aadhar_no FROM tb1_Customer WHERE aadhar_no=:ad")
							.setParameter("ad", aadharNo)
							.getSingleResult().toString();
			return aadhar_res; 
		}catch (NoResultException e) {
			return "";
		}
	}	

	@Override
	public String getCustomerByPhoneNumber(String phoneNumber) {
		try{
			String phone_res =	em
							.createNativeQuery("SELECT phone_number FROM tb1_Customer WHERE phone_number=:no")
							.setParameter("no", phoneNumber)
							.getSingleResult().toString();
			return phone_res; 
		}catch (NoResultException e) {
			return "";
		}
	}
	
	@Override
	public String getCustomerIdByAadharNo(String aadhar) {
		return em.createNativeQuery("SELECT customer_id FROM tb1_Customer WHERE aadhar_no=:ad")
				.setParameter("ad", aadhar)
				.getSingleResult().toString();
	}

	@Override
	public Customer resetPassword(Customer customer) {
		em.merge(customer);
		return customer;
		
	}

	@Override
	public Customer findById(long id) {
		return em.find(Customer.class, id);
	}
	
	@Override
	public Customer dashBoardResetPassword(Customer customer) {
		em.merge(customer);
		return customer;
	}

}
