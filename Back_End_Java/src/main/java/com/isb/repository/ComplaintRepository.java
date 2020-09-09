package com.isb.repository;

import java.util.List;

import com.isb.entity.Complaint;
import com.isb.entity.Visitor;

public interface ComplaintRepository {
	
	public void addComplaint(Complaint complaint);
	public List<Complaint> getAllComplaints();
	public String checkComplaintStatus(long  complaintNo);
	public void changeStatus(long complaintNo);
	public long findComplaintIdByMobile(long mobile);
//	List<Complaint> getAllComplaints(String status);


}
