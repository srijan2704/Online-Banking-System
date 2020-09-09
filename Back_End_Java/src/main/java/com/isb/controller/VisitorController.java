package com.isb.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isb.dto.ReferenceNo;
import com.isb.dto.ServiceReference;
import com.isb.dto.VisitorRegisterDto;
import com.isb.dto.VisitorStatus;
import com.isb.entity.Visitor;
import com.isb.exception.VisitorServiceException;
import com.isb.service.VisitorService;

@CrossOrigin
@RestController
public class VisitorController {

	@Autowired 
	VisitorService service;
	
	
	@PostMapping(path = "/registerVisitor")
	public String registerVisitor(@RequestBody VisitorRegisterDto vistorDto)
	{
		Visitor visitor = new Visitor();
		try {
		BeanUtils.copyProperties(vistorDto, visitor);
		visitor.setRegionIdLocal(service.getRegionId(vistorDto.getLocalCity(), vistorDto.getLocalPincode(), vistorDto.getLocalState()));
		visitor.setRegionIdPermanent(service.getRegionId(vistorDto.getPermanentCity(), vistorDto.getPermanentPincode(), vistorDto.getPermanentState()));
		visitor.setStatus("pending");
		return service.addVisitor(visitor);
		}
		catch(Exception e)
		{
			return "Registration Failed!";
		}
	}
	
	@PostMapping("/checkVisitorStatus")
	public VisitorStatus checkVisitorStatus(@RequestBody ServiceReference serviceRef)
	{
		VisitorStatus visitorStatus = new VisitorStatus();
		try {
		
		visitorStatus.setStatus(service.checkVisitorStatus(serviceRef.getServiceRefNo()));
		visitorStatus.setServiceRefNo(serviceRef.getServiceRefNo());
		return visitorStatus;
		}
		catch(NullPointerException e)
		{
			visitorStatus.setServiceRefNo(serviceRef.getServiceRefNo());
			visitorStatus.setStatus("Not Found!");
			return visitorStatus;
		}
				
	}
	
}
