package com.isb.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isb.entity.Customer;
import com.isb.entity.Transaction;

@Repository
public class AccountStatementImpl implements AccountStatement{
	
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Transaction> accountStatement(long customerId, Date from, Date to){
        return  (List<Transaction>)entityManager
                .createQuery("select tx from Transaction tx where tx.account.accountNo=:ac and tx.transactionDate between :from and :to")
                .setParameter("ac", getAccountNo(customerId))
                .setParameter("from", from)
                .setParameter("to", to)
                .getResultList();
    }
    
    @Override
    public long getAccountNo(long customerId) {
        return entityManager.find(Customer.class,customerId ).getAccount().getAccountNo();
    }
    
    @Override
    public List<Transaction> fetchMiniStatement(long customerId){
       List<Transaction> result  =  entityManager.createQuery("select tx from Transaction tx where tx.account.accountNo=:ac order by tx.transactionDateAndTime desc").setParameter("ac", getAccountNo(customerId)).getResultList();
       return result;
    }
	
}
