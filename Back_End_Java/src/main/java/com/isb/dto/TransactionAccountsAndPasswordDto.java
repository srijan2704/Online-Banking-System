package com.isb.dto;

import java.math.BigDecimal;

public class TransactionAccountsAndPasswordDto {

	private BigDecimal customerId;
	private BigDecimal fromAccount;
	private BigDecimal toAccount;
	private double amount;
	private String password;
	private String methodtype; 
	
	public BigDecimal getCustomerId() {
		return customerId;
	}
	public void setCustomerId(BigDecimal customerId) {
		this.customerId = customerId;
	}
	public BigDecimal getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(BigDecimal fromAccount) {
		this.fromAccount = fromAccount;
	}
	public BigDecimal getToAccount() {
		return toAccount;
	}
	public void setToAccount(BigDecimal toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMethodtype() {
		return methodtype;
	}
	public void setMethodtype(String methodtype) {
		this.methodtype = methodtype;
	}
}
