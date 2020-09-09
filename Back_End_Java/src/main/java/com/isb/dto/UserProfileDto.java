package com.isb.dto;

public class UserProfileDto {
	
	private long customerId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String aadharNo;

    private int age;

    private String localAddress;

    private String permanentAddress;

    private String debitCardStatus;

    private String netBankingStatus;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
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
    
    

}
