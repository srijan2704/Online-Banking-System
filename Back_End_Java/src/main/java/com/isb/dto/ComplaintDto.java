package com.isb.dto;

public class ComplaintDto {
	
	private String accountType;
	
	private long accountNumber;
	
	private String nameComplaint;
	
	private String branchCode;
	
	private long mobileNumber;
	
	private String email;
	
	private String categoryOfComplaint;
	
	private String complaintDesc;
	
	private String captcha;
	
	

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getNameComplaint() {
		return nameComplaint;
	}

	public void setNameComplaint(String nameComplaint) {
		this.nameComplaint = nameComplaint;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategoryOfComplaint() {
		return categoryOfComplaint;
	}

	public void setCategoryOfComplaint(String categoryOfComplaint) {
		this.categoryOfComplaint = categoryOfComplaint;
	}

	public String getComplaintDesc() {
		return complaintDesc;
	}

	public void setComplaintDesc(String complaintDesc) {
		this.complaintDesc = complaintDesc;
	}
	
	
	
}
