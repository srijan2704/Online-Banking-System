package com.isb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isb.dto.ComplaintDto;
import com.isb.dto.ComplaintNo;
import com.isb.dto.ComplaintNo1;
import com.isb.dto.ComplaintStatus;
import com.isb.entity.Complaint;
import com.isb.exception.ComplaintServiceException;
import com.isb.service.ComplaintService;

@RestController
@CrossOrigin
public class ComplaintController {
	
	@Autowired
	ComplaintService complaintService;
	
	@PostMapping("/complaint")
	public String addComplaint(@RequestBody ComplaintDto complaintDto) {
		try
		{
			Complaint complaint = new Complaint();
			complaint.setAccountNumber(complaintDto.getAccountNumber());
			complaint.setBranchCode(complaintDto.getBranchCode());
			complaint.setCategoryOfComplaint(complaintDto.getCategoryOfComplaint());
			complaint.setEmail(complaintDto.getEmail());
			complaint.setMobileNumber(complaintDto.getMobileNumber());
			complaint.setNameComplaint(complaintDto.getNameComplaint());
			complaint.setComplaintDesc(complaintDto.getComplaintDesc());
			complaint.setAccountType(complaintDto.getAccountType());
			complaint.setCaptcha(complaintDto.getCaptcha());
			complaint.setStatus("pending");
		    complaintService.addComplaint(complaint);
		    return "Successfully added!";
		}
		catch(ComplaintServiceException e)
		{
			return "Not able to add your complaint";
		}
		
	}
	
	@GetMapping("/viewComplaints")
	public List<Complaint> getComplaints() {
		List<Complaint> list=complaintService.getComplaints();
		return list;
	}
	
	@PostMapping("/checkComplaintStatus")
	public ComplaintStatus checkVisitorStatus(@RequestBody ComplaintNo cNo)
	{
		ComplaintStatus complaintStatus = new ComplaintStatus();
		try {
		complaintStatus.setStatus(complaintService.checkComplaintStatus(cNo.getComplaintNo()));
		complaintStatus.setComplaintNo(cNo.getComplaintNo());
		return complaintStatus;
		}
		catch(NullPointerException e)
		{
			complaintStatus.setStatus("No Complaint Found!");
			complaintStatus.setComplaintNo(cNo.getComplaintNo());
			return complaintStatus;
		}
				
	}
	
	@PostMapping("/changeStatus")
	public void changeStatus(@RequestBody ComplaintNo1 complaintNo1)
	{
	complaintService.changeStatus(complaintNo1.getComplaintNo());
	}
	
	
}
