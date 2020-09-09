package com.isb.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isb.entity.Account;

@Repository
public class AccountSummaryRepositoryImpl implements AccountSummaryRepository{

	@Autowired
	private AccountStatement accountStatement;
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	@Transactional
	public Account accountSummary(long customerId) {
		return (Account) entityManager

                .createQuery("select ac from Account ac where ac.accountNo=:ano")

                .setParameter("ano", accountStatement.getAccountNo(customerId))

                .getSingleResult();
	}

}
