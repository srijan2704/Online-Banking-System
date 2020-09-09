package com.isb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isb.entity.Complaint;
import com.isb.repository.ComplaintRepository;

@Service
public class ComplaintServiceImpl  implements ComplaintService{
	
	@Autowired
	private ComplaintRepository complaintRepository;
	
	@Autowired
	private SendEmail sendEmail; 


	@Override
	@Transactional
	public String addComplaint(Complaint complaint) {
		complaintRepository.addComplaint(complaint);
		long id= complaintRepository.findComplaintIdByMobile(complaint.getMobileNumber());
		String info="Your Customer Complaint ID is "+id; 
		System.out.println(id);
		sendEmail.Mailer(complaint.getEmail(), info);
		return "Complaint Registered";
	}
	

	@Override
	public List<Complaint> getComplaints() {
		return complaintRepository.getAllComplaints();
		
	}


	@Override
	public String checkComplaintStatus(long complaintNo) {
		return complaintRepository.checkComplaintStatus(complaintNo);
	}


	@Override
	public void changeStatus(long complaintNo) {
		complaintRepository.changeStatus(complaintNo);
		
	}
}
