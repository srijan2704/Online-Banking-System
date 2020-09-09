package com.isb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Complaint")
public class Complaint {
	
	@Id
	@Column(name="complaint_no")
	@SequenceGenerator(name="seq_user",initialValue=6001,allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_user")
	private long  complaintNo;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="account_no")
	private long accountNumber;
	
	@Column(name="name_complaint")
	private String nameComplaint;
	
	@Column(name="branch_code")
	private String branchCode;
	
	@Column(name="mobile_number")
	private long mobileNumber;
	
	private String email;
	@Column(name="category_of_complaint")
	
	private String categoryOfComplaint;
	@Column(name="complaint_desc")
	private String complaintDesc;
	
	@Column(name="captcha")
	private String captcha;
	
	@Column(name="status")
	private String status;

	public long getComplaintNo() {
		return complaintNo;
	}

	public void setComplaintNo(long complaintNo) {
		this.complaintNo = complaintNo;
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

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Complaint [complaintNo=" + complaintNo + ", accountType=" + accountType + ", accountNumber="
				+ accountNumber + ", nameComplaint=" + nameComplaint + ", branchCode=" + branchCode + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", categoryOfComplaint=" + categoryOfComplaint
				+ ", complaintDesc=" + complaintDesc + ", captcha=" + captcha + ", status=" + status
				+ ", getComplaintNo()=" + getComplaintNo() + ", getAccountType()=" + getAccountType()
				+ ", getAccountNumber()=" + getAccountNumber() + ", getNameComplaint()=" + getNameComplaint()
				+ ", getBranchCode()=" + getBranchCode() + ", getMobileNumber()=" + getMobileNumber() + ", getEmail()="
				+ getEmail() + ", getCategoryOfComplaint()=" + getCategoryOfComplaint() + ", getComplaintDesc()="
				+ getComplaintDesc() + ", getCaptcha()=" + getCaptcha() + ", getStatus()=" + getStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
	
	
}
