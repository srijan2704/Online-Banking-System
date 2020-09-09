package com.isb.service;

import java.util.List;

import com.isb.entity.Contact;

public interface ContactService {
	public long addContacts(Contact contact);
	public List<Contact> getAllContactsRequest();
	public void changeStatus(long contactId);


}
