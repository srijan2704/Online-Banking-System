package com.isb.repository;

import java.util.List;

import com.isb.entity.Contact;

public interface ContactRepository {
	public long addContacts(Contact contact);
	public List<Contact> getAllContactsRequest();
	public void changeStatus(long contactId);


}
