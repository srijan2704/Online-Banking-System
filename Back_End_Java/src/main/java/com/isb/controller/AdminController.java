package com.isb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isb.dto.ReferenceNo;
import com.isb.dto.StatusDto;
import com.isb.dto.VisitorStatus;
import com.isb.entity.Visitor;
import com.isb.service.AccountService;
import com.isb.service.VisitorService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/viewVisitors")
	public List<Visitor> getVisitors() {
		List<Visitor> list=visitorService.getVisitors();
		return list;
	}

	@PostMapping("/viewVisitorByStatus")
	public List<Visitor> getVisitorsByStatus(@RequestBody StatusDto statusDto) {
		List<Visitor> list = visitorService.getVisitorByStatus(statusDto.getStatus());
		return list;
	}

	@PostMapping("/DeleteVisitorByRef")
	public String deleteVisitor(@RequestBody ReferenceNo visitRef) {
		visitorService.deleteVisitor(visitRef.getServiceRefNo());
		return "Success";
	}
	
	@PostMapping("/createCustomerWithVisitor")
	public String addAccountWithCustomer(@RequestBody ReferenceNo visitRef){
		return new String().valueOf(accountService.addAccountWithCustomer(visitRef.getServiceRefNo()));
	}
}
