package com.isb.entity;

import javax.persistence.*;

@Entity
@Table(name = "TB1_VISITORS")
public class Visitor {

	@Id
	@SequenceGenerator(name = "seq_visitor" , initialValue = 1001 , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_visitor")
	@Column(name = "SERVICE_REF_NO")
	private long serviceRefNo;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "AGE")
	private int age;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "AADHAR_NO")
	private String aadharNo;

	@Column(name = "LOCAL_ADDRESS")
	private String localAddress;

	@Column(name = "REGION_ID_LOCAL")
	private long regionIdLocal;

	@Column(name = "PERMANENT_ADDRESS")
	private String permanentAddress;

	@Column(name = "REGION_ID_PERMANENT")
	private long regionIdPermanent;

	@Column(name = "OCCUPATION_TYPE")
	private String occupationType;

	@Column(name = "SOURCE_OF_INCOME")
	private String sourceOfIncome;

	@Column(name = "GROSS_ANNUAL_INCOME")
	private double grossAnnualIncome;

	@Column(name = "DEBIT_CARD_STATUS")
	private String debitCardStatus;

	@Column(name = "NET_BANKING_STATUS")
	private String netBankingStatus;
	
	private String accountType;

	public Visitor() {
	}

	public long getServiceRefNo() {
		return serviceRefNo;
	}

	public void setServiceRefNo(long serviceRefNo) {
		this.serviceRefNo = serviceRefNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public long getRegionIdLocal() {
		return regionIdLocal;
	}

	public void setRegionIdLocal(long regionIdLocal) {
		this.regionIdLocal = regionIdLocal;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public long getRegionIdPermanent() {
		return regionIdPermanent;
	}

	public void setRegionIdPermanent(long regionIdPermanent) {
		this.regionIdPermanent = regionIdPermanent;
	}

	public String getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public String getSourceOfIncome() {
		return sourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome) {
		this.sourceOfIncome = sourceOfIncome;
	}

	public double getGrossAnnualIncome() {
		return grossAnnualIncome;
	}

	public void setGrossAnnualIncome(double grossAnnualIncome) {
		this.grossAnnualIncome = grossAnnualIncome;
	}

	public String getDebitCardStatus() {
		return debitCardStatus;
	}

	public void setDebitCardStatus(String debitCardStatus) {
		this.debitCardStatus = debitCardStatus;
	}

	public String getNetBankingStatus() {
		return netBankingStatus;
	}

	public void setNetBankingStatus(String netBankingStatus) {
		this.netBankingStatus = netBankingStatus;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}