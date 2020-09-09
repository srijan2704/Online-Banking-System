package com.isb.service;

import java.util.List;

import com.isb.entity.Complaint;

public interface ComplaintService {
	
	public String addComplaint(Complaint complaint);

	public List<Complaint> getComplaints();
	public String checkComplaintStatus(long  complaintNo);
	public void changeStatus(long complaintNo);
	
	
}
