package com.isb.dto;

import com.isb.dto.Status.StatusType;

public class ResetStatus {

	private StatusType status;
	private String message;
	
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
