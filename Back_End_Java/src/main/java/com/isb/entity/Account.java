package com.isb.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Table(name="TB1_ACCOUNT")
public class Account  {

	@Id
	@SequenceGenerator(name = "seq_account" , initialValue = 100001 , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_account")
	@Column(name="ACCOUNT_NO")
	private long accountNo;

	@Column(name="ACCOUNT_BALANCE")
	private double accountBalance;

	@Column(name="ACCOUNT_STATUS")
	private String accountStatus;

	@Column(name="ACCOUNT_TYPE")
	private String accountType;

	//bi-directional many-to-one association to Tb1Customer
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;

    @JsonManagedReference
	@OneToMany(mappedBy="account")
	private List<Transaction> transactions;

	public Account() {
	}

	public long getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public double getAccountBalance() {
		return this.accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountStatus() {
		return this.accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	


//
//	public Transaction addTransactions1(Transaction transaction) {
//		getTransaction().add(transaction);
//		transaction.setToAccount(this);
//
//		return transaction;
//	}
//
//	public Transaction removeTransactions1(Transaction transaction) {
//		getTransaction().remove(transaction);
//		transaction.setToAccount(null);
//
//		return transaction;
//	}


}