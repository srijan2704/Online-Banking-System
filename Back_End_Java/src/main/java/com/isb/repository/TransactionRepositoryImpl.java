package com.isb.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.isb.dto.TransactionListDto;
import com.isb.entity.Account;
import com.isb.entity.Transaction;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void balanceUpdate(Account account)
	{
		em.merge(account);
	}

	@Override
	public void addTransaction(Transaction transaction) {
		em.merge(transaction);
	}

	@Override
	public boolean validateTransactionPassword(long customerId,String password) {
		try{
			return em
		.createNativeQuery("SELECT transaction_password FROM tb1_customer WHERE customer_id=:id")
		.setParameter("id",customerId)
		.getSingleResult().toString().equals(password) ? true : false;
		}catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public BigDecimal getTransactionNo() {
		return (BigDecimal)em
				.createNativeQuery("SELECT seq_transaction_no.nextVal FROM DUAL")
				.getSingleResult();
	}

	@Override
	public List<BigDecimal> getTransactionStatementBetweenDates(long accountNo, LocalDate fromDate, LocalDate toDate) {
		return (List<BigDecimal>)em
				.createNativeQuery("SELECT transaction_no FROM tb1_transaction WHERE account_no=:acc AND transaction_date BETWEEN :fromDate AND :toDate ORDER BY transaction_id DESC")
				.setParameter("acc", accountNo)
				.setParameter("fromDate", fromDate)
				.setParameter("toDate", toDate)
				.getResultList();
	}

	@Override
	public List<BigDecimal> fetchMiniStatement(long accountNo) {
		return (List<BigDecimal>)em
		.createNativeQuery("SELECT transaction_no FROM tb1_transaction WHERE account_no=:acc ORDER BY transaction_id DESC")
		.setParameter("acc", accountNo)
		.setMaxResults(5)
		.getResultList();
	}

	@Override
	public List<TransactionListDto> getTransactionsWithTransactionNo(List<BigDecimal> transactionNoList , long accountNo) {

		List<TransactionListDto> transactionListDtos = new ArrayList<TransactionListDto>();
		
		for(BigDecimal transactionNo : transactionNoList)
		{
			TypedQuery<Transaction> qry1 = em.createQuery("SELECT tx FROM Transaction tx WHERE tx.transactionNo=:tNo AND tx.account.accountNo=:acc", Transaction.class);
			qry1.setParameter("tNo", transactionNo.longValue());
			qry1.setParameter("acc", accountNo);
			Transaction transaction1 = qry1.getSingleResult();
			
			TypedQuery<Transaction> qry2 = em.createQuery("SELECT tx FROM Transaction tx WHERE tx.transactionNo=:tNo AND tx.account.accountNo NOT IN :acc", Transaction.class);
			qry2.setParameter("tNo", transactionNo.longValue());
			qry2.setParameter("acc", accountNo);
			Transaction transaction2 = qry2.getSingleResult();

			TransactionListDto transactionListDto = new TransactionListDto();
			
			BeanUtils.copyProperties(transaction1, transactionListDto);
			
			if(transaction1.getTransactionType().equals("Credit"))
			{
				transactionListDto.setFromAccount(transaction2.getAccount().getAccountNo());
				transactionListDto.setToAccount(transaction1.getAccount().getAccountNo());
			}
			else
			{
				transactionListDto.setFromAccount(transaction1.getAccount().getAccountNo());
				transactionListDto.setToAccount(transaction2.getAccount().getAccountNo());
			}
			
			transactionListDtos.add(transactionListDto);
			
		}
		return transactionListDtos;
	}

	@Override
	public BigDecimal getLatestTransactionNo() {
		return (BigDecimal)em.createNativeQuery("SELECT max(transaction_id) FROM tb1_transaction").getSingleResult();
	}
}
