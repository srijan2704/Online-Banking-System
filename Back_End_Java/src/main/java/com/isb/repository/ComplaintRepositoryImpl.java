package com.isb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isb.entity.Complaint;

@Repository
public class ComplaintRepositoryImpl implements ComplaintRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void addComplaint(Complaint complaint) {
		entityManager.merge(complaint);
	}

	@Override
	public List<Complaint> getAllComplaints() {
		return entityManager.createQuery("select C from Complaint C where C.status='pending' order by C.complaintNo")
				.getResultList();
	}

	@Override
	public String checkComplaintStatus(long complaintNo) {
		return entityManager
				.find(Complaint.class, complaintNo)
				.getStatus().toString();
	}

	@Override
	@Transactional
	public void changeStatus(long complaintNo) {
//		String s="Resolved";
//		Query qry=entityManager.createQuery("update Complaint C set C.status=:s where C.complaintNo:=cn");
//		qry.setParameter("cn",complaintNo);
		Complaint complaint=entityManager.find(Complaint.class,complaintNo);
		complaint.setStatus("Resolved");
		entityManager.merge(complaint);
		
	}

	@Override
	public long findComplaintIdByMobile(long mobile) {
		List<Long> complaintIds=(List<Long>)
				entityManager.createQuery("select c.complaintNo from Complaint c where c.mobileNumber=:m order by c.complaintNo")
				.setParameter("m", mobile).getResultList();
			return complaintIds.get(complaintIds.size()-1);
	}

	
	
}
