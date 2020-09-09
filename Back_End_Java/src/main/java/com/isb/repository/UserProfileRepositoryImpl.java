package com.isb.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isb.entity.Customer;

@Repository
public class UserProfileRepositoryImpl implements UserProfileRepository {

	@Autowired
	private AccountStatement accountRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Customer userProfileRepository(long customerId) {
		  return  (Customer)entityManager
                    .createQuery("select ct from Customer ct where ct.customerId=:cid")
                    .setParameter("cid", customerId)               
                    .getSingleResult();

	}

}
