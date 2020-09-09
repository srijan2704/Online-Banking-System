package com.isb.entity;

import javax.persistence.*;

@Entity
@Table(name="TB1_CUSTOMER")
public class Customer  {

	@Id
	@SequenceGenerator(name = "seq_customer" , initialValue = 10001 , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_customer")
	@Column(name="CUSTOMER_ID")
	private long customerId;

	@Column(name="AADHAR_NO")
	private String aadharNo;

	private int age;

	@Column(name="DEBIT_CARD_STATUS")
	private String debitCardStatus;

	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	private String gender;

	@Column(name="GROSS_ANNUAL_INCOME")
	private double grossAnnualIncome;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="LOCAL_ADDRESS")
	private String localAddress;

	@Column(name="LOGIN_PASSWORD")
	private String loginPassword;

	@Column(name="MIDDLE_NAME")
	private String middleName;

	@Column(name="NET_BANKING_STATUS")
	private String netBankingStatus;

	@Column(name="OCCUPATION_TYPE")
	private String occupationType;

	@Column(name="PERMANENT_ADDRESS")
	private String permanentAddress;

	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	@Column(name="REGION_ID_LOCAL")
	private long regionIdLocal;

	@Column(name="REGION_ID_PERMANENT")
	private long regionIdPermanent;

	@Column(name="SOURCE_OF_INCOME")
	private String sourceOfIncome;

	@Column(name="TRANSACTION_PASSWORD")
	private String transactionPassword;

	//bi-directional many-to-one association to Tb1Account
	@OneToOne(mappedBy="customer" , cascade = CascadeType.ALL)
	private Account account;

//	//bi-directional many-to-one association to Tb1Transaction
//	@OneToMany(mappedBy="customer")
//	private List<Transaction> transaction;

	public Customer() {
	}

	public long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getAadharNo() {
		return this.aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDebitCardStatus() {
		return this.debitCardStatus;
	}

	public void setDebitCardStatus(String debitCardStatus) {
		this.debitCardStatus = debitCardStatus;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getGrossAnnualIncome() {
		return this.grossAnnualIncome;
	}

	public void setGrossAnnualIncome(double grossAnnualIncome) {
		this.grossAnnualIncome = grossAnnualIncome;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocalAddress() {
		return this.localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getNetBankingStatus() {
		return this.netBankingStatus;
	}

	public void setNetBankingStatus(String netBankingStatus) {
		this.netBankingStatus = netBankingStatus;
	}

	public String getOccupationType() {
		return this.occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public String getPermanentAddress() {
		return this.permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getRegionIdLocal() {
		return this.regionIdLocal;
	}

	public void setRegionIdLocal(long regionIdLocal) {
		this.regionIdLocal = regionIdLocal;
	}

	public long getRegionIdPermanent() {
		return this.regionIdPermanent;
	}

	public void setRegionIdPermanent(long regionIdPermanent) {
		this.regionIdPermanent = regionIdPermanent;
	}

	public String getSourceOfIncome() {
		return this.sourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome) {
		this.sourceOfIncome = sourceOfIncome;
	}

	public String getTransactionPassword() {
		return this.transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account addAccount(Account Account) {
		Account.setCustomer(this);
		return Account;
	}

	public Account removeAccount(Account Account) {
		Account.setCustomer(null);
    	return Account;
	}

//	public List<Transaction> getTransactions() {
//		return this.transaction;
//	}
//
//	public void setTransactions(List<Transaction> transaction) {
//		this.transaction = transaction;
//	}
//
//	public Transaction addTb1Transaction(Transaction transaction) {
//		getTransactions().add(transaction);
//		transaction.setCustomer(this);
//
//		return transaction;
//	}
//
//	public Transaction removeTransaction(Transaction transaction) {
//		getTransactions().remove(transaction);
//		transaction.setCustomer(null);
//
//		return transaction;
//	}

}