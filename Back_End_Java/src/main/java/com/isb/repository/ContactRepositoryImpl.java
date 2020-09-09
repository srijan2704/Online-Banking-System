package com.isb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.isb.entity.Contact;

@Repository
public class ContactRepositoryImpl implements ContactRepository {

	@PersistenceContext
	private EntityManager em; 
	
	@Override
	@Transactional
	public long addContacts(Contact contact) {
		em.merge(contact);
		return contact.getContactId();
		
	}

	@Override
	public List<Contact> getAllContactsRequest() {
		return em.createQuery("select ct from Contact ct order by ct.contactId")
				.getResultList();
	}

	@Override
	@Transactional
	public void changeStatus(long contactId) {
		Contact contact=em.find(Contact.class,contactId);
		contact.setStatus("contacted");
		em.merge(contact);
		
	}
	}

