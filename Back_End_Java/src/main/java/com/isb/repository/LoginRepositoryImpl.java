package com.isb.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.isb.entity.Admin;
import com.isb.entity.Customer;

@Repository
public class LoginRepositoryImpl implements LoginRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Customer findCustomerById(long customer_id) {
		return entityManager.find(Customer.class,customer_id);
	}

	@Override
	public long findCustomerByIdPassword(long customerId, String password) {
		return  (long) entityManager.createQuery("select c.customerId from Customer c where c.customerId=:cus and c.loginPassword=:pass")
				.setParameter("cus", customerId)
				.setParameter("pass", password)
				.getSingleResult();
	}

	@Override
	public Admin findAdminById(long adminId) {
		return entityManager.find(Admin.class, adminId);
	}

	@Override
	public long findAdminByIdPassword(long adminId, String adminPassword) {
		return (long) entityManager.createQuery("select a.adminId from Admin a where a.adminId=: ad and a.adminPassword=:pass")
				.setParameter("ad", adminId)
				.setParameter("pass", adminPassword)
				.getSingleResult();
	}
	
}
