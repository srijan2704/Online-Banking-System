package com.isb.dto;

import java.util.Date;

public class TransactionListDto {

	public double transactionAmount;
	public Date transactionDate;
	public String transactionType;
	public String transactionMethod;
	public double openingBalance;
	public double closingBalance;
	public String transactionStatus;
	public long fromAccount;
	public long toAccount;
	
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionMethod() {
		return transactionMethod;
	}
	public void setTransactionMethod(String transactionMethod) {
		this.transactionMethod = transactionMethod;
	}
	public double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public double getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public long getToAccount() {
		return toAccount;
	}
	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}
	@Override
	public String toString() {
		return "TransactionListDto [transactionAmount=" + transactionAmount + ", transactionDate=" + transactionDate
				+ ", transactionType=" + transactionType + ", transactionMethod=" + transactionMethod
				+ ", openingBalance=" + openingBalance + ", closingBalance=" + closingBalance + ", transactionStatus="
				+ transactionStatus + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + "]";
	}
}
