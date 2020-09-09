package com.isb.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isb.entity.Transaction;
import com.isb.exception.AccountStatementServiceException;
import com.isb.repository.AccountStatement;

@Service
public class AccountStatementServiceImpl implements AccountStatementService {
	@Autowired
	AccountStatement accountStatement;
	
	@Override
    public List<Transaction> accountStatement(long customerId, Date from, Date to){


        List<Transaction> accountStatementList = accountStatement.accountStatement(customerId, from, to);

        if(accountStatementList.isEmpty())

            throw new AccountStatementServiceException("No transaction found");

        return accountStatementList;

    }

    @Override
    public List<Transaction> miniStatementList(long customerId){

        List<Transaction> miniStatementList = accountStatement.fetchMiniStatement(customerId);

        return miniStatementList;

    }
}
