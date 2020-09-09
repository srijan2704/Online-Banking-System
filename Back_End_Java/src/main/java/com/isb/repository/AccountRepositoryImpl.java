package com.isb.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.isb.entity.Account;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public long addAccount(Account account) {
		em.merge(account);
		return account.getAccountNo();
	}

	@Override
	public Account getAccount(long accNo) {
		return em.find(Account.class, accNo);
	}

}
