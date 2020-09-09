package com.isb.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TB1_TRANSACTION")
public class Transaction {
	
	@Id
	@SequenceGenerator(name = "seq_transaction" , initialValue = 1000001 , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_tranaction")
	@Column(name = "TRANSACTION_ID")
	private long transactionId;
	
	@Column(name = "TRANSACTION_NO")
	private long transactionNo;

	@Column(name = "CLOSING_BALANCE")
	private double closingBalance;

	@Column(name = "OPENING_BALANCE")
	private double openingBalance;

	@Column(name = "TRANSACTION_AMOUNT")
	private double transactionAmount;

	@Column(name = "TRANSACTION_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date transactionDate;

	@Column(name = "TRANSACTION_DATE_TIME")
	private LocalDateTime transactionDateAndTime;
	
	@Column(name = "TRANSACTION_METHOD")
	private String transactionMethod;

	@Column(name = "TRANSACTION_STATUS")
	private String transactionStatus;

	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_NO")
	private Account account;

	public Transaction() {

	}

	public long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(long transactionNo) {
		this.transactionNo = transactionNo;
	}

	public double getClosingBalance() {
		return this.closingBalance;
	}

	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public double getOpeningBalance() {
		return this.openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public double getTransactionAmount() {
		return this.transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDateTime getTransactionDateAndTime() {
		return transactionDateAndTime;
	}

	public void setTransactionDateAndTime(LocalDateTime transactionDateAndTime) {
		this.transactionDateAndTime = transactionDateAndTime;
	}

	public String getTransactionMethod() {
		return transactionMethod;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public void setTransactionMethod(String transactionMethod) {
		this.transactionMethod = transactionMethod;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", closingBalance=" + closingBalance
				+ ", openingBalance=" + openingBalance + ", transactionAmount=" + transactionAmount
				+ ", transactionDateAndTime=" + transactionDateAndTime + ", transactionMethod=" + transactionMethod
				+ ", transactionStatus=" + transactionStatus + ", transactionType=" + transactionType + "]";
	}
}
