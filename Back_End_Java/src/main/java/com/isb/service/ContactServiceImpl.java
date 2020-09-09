package com.isb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isb.entity.Contact;
import com.isb.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	@Override
	public long addContacts(Contact contact) {
		return contactRepo.addContacts(contact);

	}

	@Override
	public List<Contact> getAllContactsRequest() {
		return contactRepo.getAllContactsRequest();
	}

	@Override
	public void changeStatus(long contactId) {
		contactRepo.changeStatus(contactId);
		
	}

}
