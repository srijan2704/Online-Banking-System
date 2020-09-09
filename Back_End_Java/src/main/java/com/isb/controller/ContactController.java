package com.isb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isb.dto.ContactDto;
import com.isb.dto.ContactId;
import com.isb.entity.Contact;
import com.isb.exception.ComplaintServiceException;
import com.isb.service.ContactService;

@RestController
@CrossOrigin
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@PostMapping("/addcontact")
	public String addContact(@RequestBody ContactDto contactDto) {
		try
		{
			Contact contact=new Contact();
			contact.setFirstName(contactDto.getFirstName());
			contact.setLastName(contactDto.getLastName());
			contact.setPlace(contactDto.getPlace());
			contact.setSubject(contactDto.getSubject());
			contact.setEmail(contactDto.getEmail());
			contact.setStatus("not-contacted");
		    contactService.addContacts(contact);
			return "Successfully added!";
		}
		catch(ComplaintServiceException e)
		{
			return "Not able to add your contact request";
		}
		
	}
	
	@GetMapping("/viewContacts")
	public List<Contact> getAllContactsRequest() {
		List<Contact> list=contactService.getAllContactsRequest();
		return list;
	}
	
	

	@PostMapping("/changeContactStatus")
	public void changeStatus(@RequestBody ContactId cId)
	{
	contactService.changeStatus(cId.getContactId());
	
}
}
