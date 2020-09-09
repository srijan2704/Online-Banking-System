package com.isb.entity;

import javax.persistence.*;

@Entity
@Table(name="TB1_CUST_REP")
public class CustRep  {
	
	@Id
	@Column(name="CUST_REP_ID")
	private long custRepId;

	@Column(name="CUST_REP_NAME")
	private String custRepName;

	@Column(name="CUST_REP_PASSWORD")
	private String custRepPassword;

	public CustRep() {
	}

	public long getCustRepId() {
		return this.custRepId;
	}

	public void setCustRepId(long custRepId) {
		this.custRepId = custRepId;
	}

	public String getCustRepName() {
		return this.custRepName;
	}

	public void setCustRepName(String custRepName) {
		this.custRepName = custRepName;
	}

	public String getCustRepPassword() {
		return this.custRepPassword;
	}

	public void setCustRepPassword(String custRepPassword) {
		this.custRepPassword = custRepPassword;
	}

}