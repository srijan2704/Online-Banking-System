package com.isb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.isb.entity.Complaint;
import com.isb.entity.Contact;
import com.isb.repository.ComplaintRepository;
import com.isb.repository.ContactRepository;

@SpringBootTest
public class ComplaintTest {

//	@Autowired
//	private ComplaintRepository complaintRepo;
//	
//	@Test
//	public void addComplaint()
//	{
//		Complaint complaint = new Complaint();
//		complaint.setAccountNumber(101);
//		complaint.setBranchCode("isb001");
//		complaint.setEmail("Rihbh@gmail.com");
//		complaint.setCategoryOfComplaint("Deposits");
//		complaint.setMobileNumber(12356);
//		complaint.setComplaintDesc("unable to do processing");
//		complaint.setNameComplaint("kapil");
//		complaint.setComplaintNo(2030);
//		complaint.setCustomerType("Retail");
//		complaintRepo.addComplaint(complaint);
//	}
//	@Autowired
//	private ContactRepository contactRepository;
//	
//	@Test
//	public void addContact()
//	{
//		Contact contact = new Contact();
//		contact.setFirstName("Rishabh");
//		contact.setLastName("Kumar");
//		contact.setPlace("Delhi");
//		contact.setSubject("Account Opening");
//		contact.setStatus("not-contacted");
//		contactRepository.addCotact(contact);
//		
//	}
}
