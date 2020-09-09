package com.isb.entity;

import javax.persistence.*;

@Entity
@Table(name="TB1_ADMIN")
public class Admin  {
	@Id
	@Column(name="ADMIN_ID")
	private long adminId;

	@Column(name="ADMIN_NAME")
	private String adminName;

	@Column(name="ADMIN_PASSWORD")
	private String adminPassword;

	public Admin() {
	}

	public long getAdminId() {
		return this.adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}
	

}